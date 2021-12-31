package com.example.coeus

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.TextView
import androidx.navigation.findNavController
import com.google.android.material.textfield.TextInputLayout
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.textfield.TextInputEditText


class MeetFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_meet, container, false)
        val teacher = listOf<String>("Option 1", "Option2", "Option 3")
        val topic = listOf<String>("Option 1", "Option2", "Option 3")
//        val subtopic = listOf<String>("Option 1", "Option2", "Option 3")
        val adapter = ArrayAdapter(view.context, R.layout.dropdown_item, teacher)
        val topicAdapter = ArrayAdapter(view.context, R.layout.dropdown_item, topic)
//        val subtopicAdapter = ArrayAdapter(view.context, R.layout.dropdown_item, subtopic)
        view.findViewById<AutoCompleteTextView>(R.id.dropDownInstructor).setAdapter(adapter)
        view.findViewById<AutoCompleteTextView>(R.id.dropDownTopic).setAdapter(topicAdapter)
//        view.findViewById<AutoCompleteTextView>(R.id.dropDownSubtopic).setAdapter(subtopicAdapter)

        val materialDateBuilder: MaterialDatePicker.Builder<*> =
            MaterialDatePicker.Builder.datePicker()
        materialDateBuilder.setTitleText("SELECT A DATE");
        val materialDatePicker = materialDateBuilder.build();
        view.findViewById<TextInputEditText>(R.id.dropDownSubtopic).setOnClickListener {
            materialDatePicker.show(this.parentFragmentManager, "MATERIAL_DATE_PICKER");
        }
        materialDatePicker.addOnPositiveButtonClickListener {
            view.findViewById<TextInputEditText>(R.id.dropDownSubtopic).setText(materialDatePicker.headerText)
        }

        view.findViewById<TextView>(R.id.MeetText).setOnClickListener{
            view.findNavController().navigate(R.id.action_meetFragment_to_homePageFragment)
        }
        return view
    }
}