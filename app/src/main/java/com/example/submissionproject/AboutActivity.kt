package com.example.submissionproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem

class AboutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)


        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId ==android.R.id.home){
            finish()
            return true
        }

        return super.onOptionsItemSelected(item)
    }


}