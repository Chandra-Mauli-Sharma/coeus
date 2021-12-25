package com.example.coeus.model

import com.example.coeus.R
import com.example.coeus.data.HomeCardData

class HomeCardModel {
    fun load():List<HomeCardData>{
        return listOf(
            HomeCardData(R.drawable.ic_home_page_course_icon,"Course Page"),
            HomeCardData(R.drawable.ic_home_page_search_icon,"Search"),
            HomeCardData(R.drawable.ic_home_page_meet_icon,"1:1 with Educator"),
            HomeCardData(R.drawable.ic_home_page_calender_icon,"Calender"),
            HomeCardData(R.drawable.ic_home_page_support_icon,"Support"),
            HomeCardData(R.drawable.ic_home_page_profile_icon,"My Profile")
            )
    }
}