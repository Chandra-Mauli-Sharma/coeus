package com.example.coeus

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController

class CalendarPage: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_calendar, container, false)
        view.findViewById<ImageView>(R.id.imageView3).setOnClickListener{
            view.findNavController().navigate(R.id.action_calendarPage_to_homePageFragment)
        }
        return view
    }
}