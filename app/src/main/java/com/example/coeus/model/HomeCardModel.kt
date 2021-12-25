package com.example.coeus.model

import com.example.coeus.R
import com.example.coeus.data.HomeCardData

class HomeCardModel {
    fun load():List<HomeCardData>{
        return listOf(
            HomeCardData(R.drawable.ic_baseline_event_note_24,"Course Page"),
            HomeCardData(R.drawable.ic_baseline_search_24,"Search"),
            HomeCardData(R.drawable.ic_baseline_videocam_24,"1:1 with Educator"),
            HomeCardData(R.drawable.ic_baseline_calendar_today_24,"Calender"),
            HomeCardData(R.drawable.ic_baseline_support_24,"Support"),
            HomeCardData(R.drawable.ic_baseline_person_24,"My Profile")
            )
    }
}