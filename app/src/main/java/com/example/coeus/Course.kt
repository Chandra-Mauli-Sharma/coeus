package com.example.coeus

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.coeus.adapter.CourseAdapter
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

        view.findViewById<ImageView>(R.id.imageView3).setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.action_course_to_homePageFragment)
        }


        view.findViewById<TextView>(R.id.textView8).setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.action_course_to_homePageFragment)
        }
        recyclerView.adapter= courses?.let { CourseAdapter(it) }
        recyclerView.setHasFixedSize(true)
        return view
    }

}