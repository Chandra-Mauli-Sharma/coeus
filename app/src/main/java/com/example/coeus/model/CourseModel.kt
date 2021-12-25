package com.example.coeus.model

import android.content.Context
import com.example.coeus.data.CourseData
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException
import java.nio.charset.Charset

class CourseModel {
    fun load(context: Context):List<CourseData>{
        val jsonResponse = ArrayList<CourseData>()

        try{
            val obj = JSONObject(getJSONFromAssets(context)!!)

            val courseArray = obj.getJSONArray("Courses")

            for(i in 0 until courseArray.length()){
                val courseResponse = courseArray.getJSONObject(i)
                val courseName = courseResponse.getString("courseName")
                val instructorName = courseResponse.getString("instructorName")
                val rating = courseResponse.getString("rating")
                val duration = courseResponse.getString("duration")

                jsonResponse.add(CourseData(courseName, instructorName, rating, duration))

            }
        } catch(e:JSONException){
            e.printStackTrace()
        }

        return jsonResponse
    }

    private fun getJSONFromAssets(context:Context): String? {

        var json: String? = null
        val charset: Charset = Charsets.UTF_8
        try {
            val courseJSONFile = context.assets.open("courses.json")
            val size = courseJSONFile.available()
            val buffer = ByteArray(size)
            courseJSONFile.read(buffer)
            courseJSONFile.close()
            json = String(buffer, charset)
        } catch (ex: IOException) {
            ex.printStackTrace()
            return null
        }
        return json
    }
}