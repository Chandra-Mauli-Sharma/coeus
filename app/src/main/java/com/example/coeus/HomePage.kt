package com.example.coeus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.coeus.adapter.HomeCardAdapter
import com.example.coeus.model.HomeCardModel
import java.util.*

class HomePage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)

        setHomeGreeting()
        val profliePicBackground = findViewById<ImageView>(R.id.imageView)
        val profilePic = findViewById<ImageView>(R.id.imageView4)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val cardImg = HomeCardModel().load()
        Glide.with(this)
            .load(R.drawable.ani).circleCrop().into(profilePic)
        Glide.with(this)
            .load(R.drawable.ic_memoji)
            .circleCrop()
            .into(profliePicBackground);

        recyclerView.adapter = HomeCardAdapter(cardImg)
        recyclerView.setHasFixedSize(true)
    }

    fun setHomeGreeting() {
        val c = Calendar.getInstance()
        val timeOfDay = c.get(Calendar.HOUR_OF_DAY)

        findViewById<TextView>(R.id.textView4).text = when (timeOfDay) {
            in 0..11 -> "Good Morning!"
            in 12..15 -> "Good Afternoon!"
            else -> "Good Evening!"
        }
    }
}