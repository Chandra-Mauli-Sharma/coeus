package com.example.coeus

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.activity.addCallback
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.coeus.viewmodels.UserViewModel


class LandingPage : Fragment() {
    private lateinit var mUserViewModel: UserViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_landing_page, container, false)
        mUserViewModel = ViewModelProvider(this)[UserViewModel::class.java]
        mUserViewModel.allUsers.observe(viewLifecycleOwner, { user ->
            if (user.isNullOrEmpty()) {
                view.findViewById<TextView>(R.id.textView2).setOnClickListener {
                    Navigation.findNavController(view).navigate(R.id.action_landingPage_to_signUp)
                }
            } else {
                Navigation.findNavController(view)
                    .navigate(R.id.action_landingPage_to_homePageFragment)
            }
        })

        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
            activity?.finish()
        }

        return view
    }
}