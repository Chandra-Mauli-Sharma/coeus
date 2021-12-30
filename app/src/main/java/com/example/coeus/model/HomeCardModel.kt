package com.example.coeus.model

import com.example.coeus.R
import com.example.coeus.data.HomeCardData

class HomeCardModel {
    fun load(): List<HomeCardData> {
        return listOf(
            HomeCardData(
                R.drawable.ic_home_page_course_icon,
                "Course Page",
                R.id.action_homePageFragment_to_course
            ),
            HomeCardData(
                R.drawable.ic_home_page_search_icon,
                "Search",
                R.id.action_homePageFragment_to_searchFragment
            ),
            HomeCardData(
                R.drawable.ic_home_page_meet_icon,
                "1:1 with Educator",
                R.id.action_homePageFragment_to_meetFragment
            ),
            HomeCardData(
                R.drawable.ic_home_page_calender_icon,
                "Calender",
                R.id.action_homePageFragment_to_calendarPage
            ),
            HomeCardData(
                R.drawable.ic_home_page_support_icon,
                "Support",
                R.id.action_homePageFragment_to_supportFragment
            ),
            HomeCardData(
                R.drawable.ic_home_page_profile_icon,
                "My Profile",
                R.id.action_homePageFragment_to_profileFragment
            )
        )
    }
}