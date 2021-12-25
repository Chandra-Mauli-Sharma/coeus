package com.example.coeus.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.coeus.Course
import com.example.coeus.R
import com.example.coeus.data.HomeCardData

class HomeCardAdapter(val dataset:List<HomeCardData>):RecyclerView.Adapter<HomeCardAdapter.ViewHolder>(){
    class ViewHolder(view: View):RecyclerView.ViewHolder(view){
        val imageView=view.findViewById<ImageView>(R.id.imageView2)
        val textView=view.findViewById<TextView>(R.id.textView7)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context).inflate(R.layout.home_page_card, parent, false)
        return ViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = dataset[position]
        Glide.with(holder.itemView.context).load(item.image).into(holder.imageView)
        holder.textView.text=item.text
        holder.itemView.setOnClickListener{
            when(position){
                0 -> Navigation.findNavController(holder.itemView).navigate(R.id.action_homePageFragment_to_course)
            }

        }
    }

    override fun getItemCount(): Int = dataset.size
}