package com.example.submissionproject


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var rvMembers: RecyclerView
    private val list = ArrayList<Member>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvMembers = findViewById(R.id.rv_member)
        rvMembers.setHasFixedSize(true)

        list.addAll(getListMembers())
        showRecyclerList()


        window.statusBarColor = ContextCompat.getColor(this, R.color.darkPrimaryColor)


    }

    private fun getListMembers(): ArrayList<Member> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.getStringArray(R.array.data_photo)
        val listMember = ArrayList<Member>()
        for(i in dataName.indices){
            val member = Member(dataName[i], dataDescription[i], dataPhoto[i])
            listMember.add(member)
        }
        return listMember
    }

    private fun showRecyclerList(){
        rvMembers.layoutManager = LinearLayoutManager(this)
        val listMemberAdapter = MemberAdapter(list)
        rvMembers.adapter = listMemberAdapter

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.btn_go_about -> {

                val intent = Intent(this, AboutActivity::class.java)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }




}