package com.example.coeus.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "meets")
data class MeetEntity(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "instructor") val instructor: String,
    @ColumnInfo(name = "topic") val topic: String,
    @ColumnInfo(name = "date") val date: Date,
    @ColumnInfo(name = "desc") val desc: String,
    @ColumnInfo(name = "link") val meet: String
)