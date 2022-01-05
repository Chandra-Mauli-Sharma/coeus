package com.example.coeus

import android.content.DialogInterface
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.coeus.viewmodels.MeetViewModel
import com.github.sundeepk.compactcalendarview.CompactCalendarView
import com.github.sundeepk.compactcalendarview.CompactCalendarView.CompactCalendarViewListener
import com.github.sundeepk.compactcalendarview.domain.Event
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import java.text.SimpleDateFormat
import java.util.*
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.coeus.adapter.MeetJoinAdapter


class CalendarPage : Fragment() {
    private lateinit var mMeetViewModel: MeetViewModel
    private lateinit var joinDialog : View
    private val dateFormatMonth: SimpleDateFormat =
        SimpleDateFormat("MMMM yyyy", Locale.getDefault())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_calendar, container, false)
        mMeetViewModel = ViewModelProvider(this)[MeetViewModel::class.java]

        val calendar = view.findViewById<CompactCalendarView>(R.id.calendarView)
        val month = view.findViewById<TextView>(R.id.textView16)

        month.text = dateFormatMonth.format(calendar.firstDayOfCurrentMonth)
        mMeetViewModel.allMeets.observe(viewLifecycleOwner, { meet ->
            meet.forEach {
                val event = Event(Color.GREEN, it.date.time)
                calendar.addEvent(event)
            }
        })

        view.findViewById<ImageView>(R.id.imageView11).setOnClickListener {
            calendar.scrollLeft()
        }
        view.findViewById<ImageView>(R.id.imageView12).setOnClickListener {
            calendar.scrollRight()
        }


        calendar.setListener(object : CompactCalendarViewListener {
            override fun onDayClick(dateClicked: Date) {
                //Add dialog with events
                val events = mMeetViewModel.allMeets.value?.filter { it.date == dateClicked }

                if (!events.isNullOrEmpty()) {
                    joinDialog = LayoutInflater.from(context)
                        .inflate(R.layout.fragment_meet_join, null, false)
                    joinDialog.findViewById<RecyclerView>(R.id.joinList).apply {
                        adapter = MeetJoinAdapter(events)
                        layoutManager=LinearLayoutManager(context)
                    }

                    MaterialAlertDialogBuilder(view.context).setTitle("Meets").setView(joinDialog)
                        .setPositiveButton("Okay") { dialog, which -> {} }.create()
                        .show()
                }
            }

            override fun onMonthScroll(firstDayOfNewMonth: Date) {
                month.text = dateFormatMonth.format(firstDayOfNewMonth)
            }
        })

        view.findViewById<TextView>(R.id.textView9).setOnClickListener {
            view.findNavController().navigate(R.id.action_calendarPage_to_homePageFragment)
        }
        return view
    }
}