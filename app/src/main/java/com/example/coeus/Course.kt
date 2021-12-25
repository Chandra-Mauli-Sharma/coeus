package com.example.coeus

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.coeus.adapter.CourseAdapter
import com.example.coeus.data.CourseData
import com.example.coeus.model.CourseModel

class Course : Fragment() {
    lateinit var recyclerView: RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_course, container, false)
        recyclerView=view.findViewById(R.id.recyclerView2)

        val courses= context?.let { CourseModel().load(it) }

        recyclerView.adapter= courses?.let { CourseAdapter(it) }
        recyclerView.setHasFixedSize(true)
        return view
    }

}