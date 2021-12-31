package com.example.coeus

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.button.MaterialButton
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import com.example.coeus.model.UserEntity
import com.example.coeus.viewmodels.UserViewModel
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout


class ProfileFragment : Fragment() {
    private lateinit var mUserViewModel: UserViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_profile, container, false)

        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        view.findViewById<MaterialButton>(R.id.doneBtn).setOnClickListener {
            val name = view.findViewById<TextInputEditText>(R.id.nameField).text.toString()
            val phone = view.findViewById<TextInputEditText>(R.id.phoneField).text.toString()
            val city = view.findViewById<TextInputEditText>(R.id.cityField).text.toString()
            val state = view.findViewById<TextInputEditText>(R.id.stateField).text.toString()
            val lang = view.findViewById<TextInputEditText>(R.id.langField).text.toString()
            val dob = view.findViewById<TextInputEditText>(R.id.dobField).text.toString()
            val email = view.findViewById<TextInputEditText>(R.id.emailField).text.toString()

            mUserViewModel.insert(UserEntity(name, phone,city,state,lang,dob,email))
            Toast.makeText(this.requireContext(),"User updated",Toast.LENGTH_SHORT).show()
        }

        view.findViewById<TextView>(R.id.ProfileText).setOnClickListener{
            view.findNavController().navigate(R.id.action_profileFragment_to_homePageFragment)
        }
        return view
    }

}