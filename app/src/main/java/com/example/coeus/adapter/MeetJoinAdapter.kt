package com.example.coeus.adapter

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.coeus.R
import com.example.coeus.model.MeetEntity
import java.time.LocalDateTime
import java.util.*

class MeetJoinAdapter(val dataset: List<MeetEntity>) :
    RecyclerView.Adapter<MeetJoinAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val meetDetail = view.findViewById<TextView>(R.id.meetDetail)
        val joinMeet = view.findViewById<TextView>(R.id.joinMeet)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val adapterLayout =
            LayoutInflater.from(parent.context).inflate(R.layout.meet_join_list, parent, false)
        return ViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = dataset[position]

        holder.meetDetail.text = item.desc



        holder.joinMeet.setOnClickListener {
            if (item.date.date == Date().date) {
                holder.itemView.context.startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse(item.meet)
                    )
                )
            } else {
                Toast.makeText(
                    holder.itemView.context,
                    "The Meet is on ${SimpleDateFormat("MMMM dd, yyyy").format(item.date)}",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

    }

    override fun getItemCount(): Int = dataset.size
}
