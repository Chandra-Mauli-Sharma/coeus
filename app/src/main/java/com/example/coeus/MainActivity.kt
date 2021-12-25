package com.example.coeus

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mFragmentActivity=supportFragmentManager
        val mFragmentTransaction=mFragmentActivity.beginTransaction()
        val mFragment=Course()


        findViewById<TextView>(R.id.textView2).setOnClickListener {
            startActivity(Intent(this,HostPage::class.java))
        }
    }
}