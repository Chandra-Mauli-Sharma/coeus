package com.example.coeus.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//TODO make dob date
@Entity(tableName = "users")
data class UserEntity(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "mobnum") val mobileNo: String,
    @ColumnInfo(name = "city") val city: String,
    @ColumnInfo(name = "state") val state: String,
    @ColumnInfo(name = "lang") val lang: String,
    @ColumnInfo(name = "dob") val dob: String,
    @ColumnInfo(name = "email") val email: String,
    @ColumnInfo(name = "courseName") val courseName: String,
) {
    constructor(
        name: String = "",
        mobileNo: String = "",
        city: String = "",
        state: String = "",
        lang: String = "",
        dob: String = "",
        email: String = "",
        courseName: String = ""
    ) : this(0, name, mobileNo, city, state, lang, dob, email, courseName)
}