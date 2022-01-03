package com.example.coeus

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.addCallback
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.coeus.adapter.HomeCardAdapter
import com.example.coeus.model.HomeCardModel
import com.example.coeus.model.UserEntity
import com.example.coeus.viewmodels.UserViewModel
import java.util.*
import kotlin.system.exitProcess

class HomePageFragment : Fragment() {

    private lateinit var mUserViewModel: UserViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home_page, container, false)
        mUserViewModel = ViewModelProvider(this)[UserViewModel::class.java]
        val greetingText = view.findViewById<TextView>(R.id.textView4)

        mUserViewModel.allUsers.observe(viewLifecycleOwner, { user ->
            if (user.isNullOrEmpty()){
                greetingText.text= "Hello!"
            }else{
                greetingText.text= "Hello! \n" + user.first().name
            }
         })
        val profliePicBackground = view.findViewById<ImageView>(R.id.imageView)
        val profilePic = view.findViewById<ImageView>(R.id.imageView4)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        val cardImg = HomeCardModel().load()
        Glide.with(this)
            .load(R.drawable.ani).circleCrop().into(profilePic)
        Glide.with(this)
            .load(R.drawable.ic_memoji)
            .circleCrop()
            .into(profliePicBackground);

        recyclerView.adapter = HomeCardAdapter(cardImg)
        recyclerView.setHasFixedSize(true)

        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner){
            activity?.finish()
        }

        return view
    }


}