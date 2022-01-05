package com.example.coeus.adapter

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.coeus.R
import com.example.coeus.data.CourseData

class SearchCourseAdapter(var dataset: List<CourseData>) :
    RecyclerView.Adapter<SearchCourseAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var courseName = view.findViewById<TextView>(R.id.SearchCourseName)
        var courseStatus = view.findViewById<ImageView>(R.id.CourseStatus)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val adapterLayout =
            LayoutInflater.from(parent.context).inflate(R.layout.search_result, parent, false)
        return ViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = dataset[position]

        holder.courseName.text = item.courseName
        holder.courseStatus.setOnClickListener{
            holder.courseStatus.setImageResource(R.drawable.ic_green_confirm_tick)
        }
        holder.itemView.setOnClickListener {
            holder.itemView.context.startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://www.udemy.com/courses/search/?q=${item.courseName}&sort=highest-rated")
                )
            )
        }
    }

    override fun getItemCount(): Int = dataset.size

    fun filterList(filterllist: ArrayList<CourseData>) {
        dataset = filterllist
        notifyDataSetChanged()
    }
}