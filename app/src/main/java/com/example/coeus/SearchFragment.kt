package com.example.coeus

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.SearchView
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.coeus.adapter.CourseAdapter
import com.example.coeus.adapter.SearchCourseAdapter
import com.example.coeus.data.CourseData
import com.example.coeus.model.CourseModel
import java.util.*
import kotlin.collections.ArrayList


class SearchFragment : Fragment() {
    lateinit var recyclerView: RecyclerView
    lateinit var courseData:List<CourseData>
    lateinit var adapter:SearchCourseAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_search, container, false)

        val searchView=view.findViewById<SearchView>(R.id.searchView)
        recyclerView=view.findViewById(R.id.recyclerView3)
        courseData = context?.let { CourseModel().load(it) }!!
        view.findViewById<TextView>(R.id.SearchText).setOnClickListener{
            view.findNavController().navigate(R.id.action_searchFragment_to_homePageFragment)
        }
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                filter(newText)
                return false
            }
        })
        adapter = SearchCourseAdapter(courseData)
        recyclerView.adapter= adapter
        recyclerView.setHasFixedSize(true)

        return view
    }
    private fun filter(text: String) {
        val filteredlist: ArrayList<CourseData> = ArrayList()

        for (item in courseData) {
            if (item.courseName.lowercase(Locale.getDefault()).contains(text.lowercase(Locale.getDefault()))) {
                filteredlist.add(item)
            }
        }
        if (filteredlist.isEmpty()) {
            Toast.makeText(context, "No Data Found", Toast.LENGTH_SHORT).show()
            adapter.filterList(filteredlist)
        } else {
            adapter.filterList(filteredlist)
        }
    }


}