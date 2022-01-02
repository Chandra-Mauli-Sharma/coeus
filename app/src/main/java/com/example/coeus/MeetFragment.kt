package com.example.coeus

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.coeus.model.MeetEntity
import com.example.coeus.viewmodels.MeetViewModel
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.textfield.TextInputEditText
import java.util.*


class MeetFragment : Fragment() {
    private lateinit var mMeetViewModel: MeetViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_meet, container, false)
        mMeetViewModel = ViewModelProvider(this)[MeetViewModel::class.java]

        val teacher = listOf<String>("Option 1", "Option2", "Option 3")
        val topics = listOf<String>("Option 1", "Option2", "Option 3")
        val adapter = ArrayAdapter(view.context, R.layout.dropdown_item, teacher)
        val topicAdapter = ArrayAdapter(view.context, R.layout.dropdown_item, topics)
        view.findViewById<AutoCompleteTextView>(R.id.dropDownInstructor).setAdapter(adapter)
        view.findViewById<AutoCompleteTextView>(R.id.dropDownTopic).setAdapter(topicAdapter)

        val materialDateBuilder: MaterialDatePicker.Builder<*> =
            MaterialDatePicker.Builder.datePicker()
        materialDateBuilder.setTitleText("SELECT A DATE");
        val materialDatePicker = materialDateBuilder.build();
        view.findViewById<TextInputEditText>(R.id.dropDownSubtopic).setOnClickListener {
            materialDatePicker.show(this.parentFragmentManager, "MATERIAL_DATE_PICKER");
        }
        var datePicked: Date = Date()
        materialDatePicker.addOnPositiveButtonClickListener { date ->
            view.findViewById<TextInputEditText>(R.id.dropDownSubtopic)
                .setText(materialDatePicker.headerText)
            datePicked = Date(materialDatePicker.headerText)
        }


        //Schedule
        view.findViewById<AppCompatButton>(R.id.scheduleMeet).setOnClickListener {
            val instructor =
                view.findViewById<AutoCompleteTextView>(R.id.dropDownInstructor).text.toString()
            val topic = view.findViewById<AutoCompleteTextView>(R.id.dropDownTopic).text.toString()
            val desc = view.findViewById<TextInputEditText>(R.id.descMeet).text.toString()
            if (instructor.isEmpty() || topic.isEmpty() || desc.length > 25 || desc.isEmpty()) {
                println("here")
                Toast.makeText(view.context, "Fill all the fields", Toast.LENGTH_SHORT).show()
            } else {
                mMeetViewModel.schedule(MeetEntity(0, instructor, topic, datePicked, desc))
                Toast.makeText(view.context, "Meet Scheduled check Calendar", Toast.LENGTH_SHORT).show()
            }
        }

        view.findViewById<TextView>(R.id.MeetText).setOnClickListener {
            view.findNavController().navigate(R.id.action_meetFragment_to_homePageFragment)
        }
        return view
    }

    private fun scheduleMeet(date: Date) {

    }
}