package com.example.coeus

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.Navigation


class LandingPage : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_landing_page, container, false)
        view.findViewById<TextView>(R.id.textView2).setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_landingPage_to_homePageFragment)
        }
        return view
    }
}