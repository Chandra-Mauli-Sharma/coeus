package com.example.coeus

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.addCallback
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.coeus.model.UserEntity
import com.example.coeus.viewmodels.UserViewModel
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

class SignUp : Fragment() {
    private lateinit var mUserViewModel: UserViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_sign_up, container, false)
        mUserViewModel = ViewModelProvider(this)[UserViewModel::class.java]

        view.findViewById<Button>(R.id.SignIn).setOnClickListener {
            val name = view.findViewById<TextInputEditText>(R.id.nameField).text.toString()
            val courseName = view.findViewById<TextInputEditText>(R.id.nameField2).text.toString()

            if (name.isEmpty() || courseName.isEmpty()) {
                Toast.makeText(context,"Text Field Empty",Toast.LENGTH_SHORT).show()
            } else {
                mUserViewModel.insert(UserEntity(name = name, courseName = courseName))
                Navigation.findNavController(view).navigate(R.id.action_signUp_to_homePageFragment)
            }
        }

        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
            activity?.finish()
        }
        return view
    }

}