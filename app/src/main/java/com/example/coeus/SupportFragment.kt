package com.example.coeus

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.Navigation


class SupportFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_support, container, false)

        view.findViewById<ImageView>(R.id.back).setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.action_supportFragment_to_homePageFragment)
        }


        view.findViewById<TextView>(R.id.PageText).setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.action_supportFragment_to_homePageFragment)
        }
        return view
    }
}