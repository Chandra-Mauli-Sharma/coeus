package com.example.coeus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.coeus.adapter.HomeCardAdapter
import com.example.coeus.model.HomeCardModel

class HomePage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)

        val profliePic=findViewById<ImageView>(R.id.imageView)
        val recyclerView=findViewById<RecyclerView>(R.id.recyclerView)
        val cardImg=HomeCardModel().load()
        Glide.with(this)
            .load(R.drawable.pic)
            .circleCrop()
            .into(profliePic);

        recyclerView.adapter = HomeCardAdapter(cardImg)
        recyclerView.setHasFixedSize(true)
    }
}