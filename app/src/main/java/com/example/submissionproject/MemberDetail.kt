package com.example.submissionproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class MemberDetail : AppCompatActivity() {

    companion object{
        const val KEY_MEMBER = "key_member"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_member_detail)

        val name = resources.getStringArray(R.array.data_name)
        val description = resources.getStringArray(R.array.data_description)
        val photo = resources.getStringArray(R.array.data_photo)

        val members = mutableListOf<Member>()
        for (i in name.indices) {
            val member = Member(
                name = name[i],
                description = description[i],
                photo = photo[i]
            )
            members.add(member)
        }


        @Suppress("DEPRECATION")
        val dataMember = intent.getParcelableExtra(KEY_MEMBER) as Member?

        dataMember?.let { member ->

            findViewById<TextView>(R.id.name_member_detail).text = member.name
            findViewById<TextView>(R.id.description_member_detail).text = member.description

            val imageView = findViewById<ImageView>(R.id.image_member_detail)
            Glide.with(this)
                .load(member.photo)
                .into(imageView)


            val btnShare = findViewById<Button>(R.id.btn_share)
            btnShare.setOnClickListener{
                shareMemberDetails(member)
            }
        }

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun shareMemberDetails(member: Member){
        val shareText = "Check out this member:\n\nName: ${member.name}\nDescription: ${member.description}"
        val shareIntent = Intent(Intent.ACTION_SEND).apply {
            type = "text/plain"
            putExtra(Intent.EXTRA_TEXT, shareText)
        }
        startActivity(Intent.createChooser(shareIntent, "Share via"))
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId ==android.R.id.home){
            finish()
            return true
        }

        return super.onOptionsItemSelected(item)
    }
}