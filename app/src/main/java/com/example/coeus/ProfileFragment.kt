package com.example.coeus

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.google.android.material.button.MaterialButton
import androidx.navigation.findNavController
import com.example.coeus.model.UserEntity
import com.example.coeus.viewmodels.UserViewModel
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout


class ProfileFragment : Fragment() {
    private lateinit var mUserViewModel: UserViewModel
    private lateinit var userName: String
    private lateinit var courseName: String
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_profile, container, false)

        mUserViewModel = ViewModelProvider(this)[UserViewModel::class.java]

        val nameField = view.findViewById<TextInputEditText>(R.id.nameField)
        val phoneField = view.findViewById<TextInputEditText>(R.id.phoneField)
        val cityField = view.findViewById<TextInputEditText>(R.id.cityField)
        val stateField = view.findViewById<TextInputEditText>(R.id.stateField)
        val langField = view.findViewById<TextInputEditText>(R.id.langField)
        val dobField = view.findViewById<TextInputEditText>(R.id.dobField)
        val emailField = view.findViewById<TextInputEditText>(R.id.emailField)
        mUserViewModel.allUsers.observe(viewLifecycleOwner, { user ->
            userName = user.first().name
            courseName = user.first().courseName
            view.findViewById<TextView>(R.id.userName).text = userName
            view.findViewById<TextView>(R.id.courseName).text = courseName
            if (user.first().city.isEmpty() && user.first().email.isEmpty() && user.first().courseName.isEmpty() && user.first().dob.isEmpty() && user.first().lang.isEmpty() && user.first().mobileNo.isEmpty() && user.first().state.isEmpty() && user.first().name.isEmpty()) {
                view.findViewById<MaterialButton>(R.id.doneBtn).setOnClickListener {
                    val name = nameField.text.toString()
                    val phone = phoneField.text.toString()
                    val city = cityField.text.toString()
                    val state = stateField.text.toString()
                    val lang = langField.text.toString()
                    val dob = dobField.text.toString()
                    val email = emailField.text.toString()

                    mUserViewModel.insert(
                        UserEntity(
                            name,
                            phone,
                            city,
                            state,
                            lang,
                            dob,
                            email,
                            courseName
                        )
                    )
                    Toast.makeText(this.requireContext(), "User updated", Toast.LENGTH_SHORT).show()
                }
            } else {
                nameField.setText(user.first().name)
                phoneField.setText(user.first().mobileNo)
                cityField.setText(user.first().city)
                stateField.setText(user.first().state)
                langField.setText(user.first().lang)
                dobField.setText(user.first().dob)
                emailField.setText(user.first().email)

                nameField.isFocusable = false
                phoneField.isFocusable = false
                cityField.isFocusable = false
                stateField.isFocusable = false
                langField.isFocusable = false
                dobField.isFocusable = false
                emailField.isFocusable = false
            }
        })
        view.findViewById<Button>(R.id.LogOut).setOnClickListener {
            mUserViewModel.delete()
            Navigation.findNavController(view).navigate(R.id.action_profileFragment_to_signUp)
        }

        view.findViewById<TextView>(R.id.ProfileText).setOnClickListener {
            view.findNavController().navigate(R.id.action_profileFragment_to_homePageFragment)
        }
        return view
    }

}