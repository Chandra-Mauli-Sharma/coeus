package com.example.coeus.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.coeus.R
import com.example.coeus.data.CourseData

class CourseAdapter (val dataset:List<CourseData>):RecyclerView.Adapter<CourseAdapter.ViewHolder>(){
    class ViewHolder(view: View):RecyclerView.ViewHolder(view){
        val courseName=view.findViewById<TextView>(R.id.textView9)
        val instructor=view.findViewById<TextView>(R.id.textView10)
        val rating=view.findViewById<TextView>(R.id.textView11)
        val duration=view.findViewById<TextView>(R.id.textView12)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context).inflate(R.layout.course_card, parent, false)
        return ViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item=dataset[position]

        holder.courseName.text=item.courseName
        holder.instructor.text=item.instructorName
        holder.duration.text=item.duration
        holder.rating.text=item.rating

    }

    override fun getItemCount(): Int = dataset.size
}