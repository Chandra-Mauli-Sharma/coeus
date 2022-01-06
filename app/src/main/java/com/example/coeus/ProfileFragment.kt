package com.example.coeus

import android.os.Bundle
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.widget.doOnTextChanged
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.google.android.material.button.MaterialButton
import com.example.coeus.model.UserEntity
import com.example.coeus.viewmodels.MeetViewModel
import com.example.coeus.viewmodels.UserViewModel
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import java.text.SimpleDateFormat
import java.util.*

class ProfileFragment : Fragment() {
    private lateinit var mUserViewModel: UserViewModel
    private lateinit var mMeetViewModel: MeetViewModel
    private lateinit var userName: String
    private lateinit var courseName: String
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_profile, container, false)

        mUserViewModel = ViewModelProvider(this)[UserViewModel::class.java]
        mMeetViewModel = ViewModelProvider(this)[MeetViewModel::class.java]

        val nameField = view.findViewById<TextInputEditText>(R.id.nameField)
        val phoneField = view.findViewById<TextInputEditText>(R.id.phoneField)
        val cityField = view.findViewById<TextInputEditText>(R.id.cityField)
        val stateField = view.findViewById<TextInputEditText>(R.id.stateField)
        val langField = view.findViewById<TextInputEditText>(R.id.langField)
        val dobField = view.findViewById<TextInputEditText>(R.id.dobField)
        val emailField = view.findViewById<TextInputEditText>(R.id.emailField)


        val emailInput = view.findViewById<TextInputLayout>(R.id.emailTextInput)

        emailField.doOnTextChanged { _, _, _, _ -> validateEmailAddress(emailField, emailInput) }

        var datePicked: Date = Date()

        mUserViewModel.allUsers.observe(viewLifecycleOwner, { user ->
            userName = user.first().name
            courseName = user.first().courseName
            view.findViewById<TextView>(R.id.userName).text = userName
            view.findViewById<TextView>(R.id.courseName).text = courseName
            if (user.first().city.isEmpty() && user.first().email.isEmpty() && user.first().dob.isEmpty() && user.first().lang.isEmpty() && user.first().mobileNo.isEmpty() && user.first().state.isEmpty()) {
                if (dobField.text.toString().isEmpty()) {
                    view.findViewById<TextInputEditText>(R.id.dobField).setOnClickListener {
                        val materialDateBuilder: MaterialDatePicker.Builder<*> =
                            MaterialDatePicker.Builder.datePicker()
                        materialDateBuilder.setTitleText("SELECT A DATE");
                        val materialDatePicker = materialDateBuilder.build();
                        materialDatePicker.show(
                            this.parentFragmentManager,
                            "MATERIAL_DATE_PICKER"
                        );
                        materialDatePicker.addOnPositiveButtonClickListener {
                            view.findViewById<TextInputEditText>(R.id.dobField)
                                .setText(materialDatePicker.headerText)
                            datePicked = Date(materialDatePicker.headerText)
                        }
                    }
                }
                view.findViewById<MaterialButton>(R.id.doneBtn).setOnClickListener {
                    val name = nameField.text.toString()
                    val phone = phoneField.text.toString()
                    val city = cityField.text.toString()
                    val state = stateField.text.toString()
                    val lang = langField.text.toString()
                    val email = emailField.text.toString()
                    if (name.isEmpty() && phone.isEmpty() && city.isEmpty() && state.isEmpty() && lang.isEmpty() && email.isEmpty()) {
                        Toast.makeText(context, "Text Field are empty", Toast.LENGTH_SHORT).show()
                    } else {
                        mUserViewModel.insert(
                            UserEntity(
                                name,
                                phone,
                                city,
                                state,
                                lang,
                                SimpleDateFormat("MMMM dd, yyyy", Locale.US).format(datePicked)
                                    .toString(),
                                email,
                                courseName
                            )
                        )
                        Toast.makeText(context, "User updated", Toast.LENGTH_SHORT)
                            .show()
                    }
                }
            } else {
                nameField.setText(user.first().name)
                phoneField.setText(user.first().mobileNo)
                cityField.setText(user.first().city)
                stateField.setText(user.first().state)
                langField.setText(user.first().lang)
                dobField.setText(user.first().dob)
                emailField.setText(user.first().email)

                nameField.isFocusable = nameField.text.isNullOrEmpty()
                phoneField.isFocusable = phoneField.text.isNullOrEmpty()
                cityField.isFocusable = cityField.text.isNullOrEmpty()
                stateField.isFocusable = stateField.text.isNullOrEmpty()
                langField.isFocusable = langField.text.isNullOrEmpty()
                dobField.isFocusable = dobField.text.isNullOrEmpty()
                emailField.isFocusable = emailField.text.isNullOrEmpty()
            }
        })

        view.findViewById<Button>(R.id.LogOut).setOnClickListener {
            mUserViewModel.delete()
            mMeetViewModel.delete()
            Navigation.findNavController(view).navigate(R.id.action_profileFragment_to_signUp)
        }

        view.findViewById<TextView>(R.id.ProfileText).setOnClickListener {
            view.findNavController().navigate(R.id.action_profileFragment_to_homePageFragment)
        }
        return view
    }

    private fun validateEmailAddress(emailInput: TextInputEditText, emailLayout: TextInputLayout) {
        val emailField = emailInput.text.toString()
        if (emailField.isNotEmpty() && Patterns.EMAIL_ADDRESS.matcher(emailField).matches()) {
            emailLayout.helperText = ""
        } else {
            emailLayout.helperText = "Invalid Email"
        }
    }

}