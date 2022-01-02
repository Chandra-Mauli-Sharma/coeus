package com.example.coeus.db

import android.content.Context
import androidx.room.*
import com.example.coeus.dao.MeetDao
import com.example.coeus.dao.UserDAO
import com.example.coeus.model.MeetEntity
import com.example.coeus.model.UserEntity
import java.util.Date

@Database(entities = [UserEntity::class, MeetEntity::class], version = 2)
@TypeConverters(Converters::class)
abstract class UserDB : RoomDatabase() {
    abstract fun userDao(): UserDAO
    abstract fun meetDao():MeetDao

    companion object {
        @Volatile
        private var instance: UserDB? = null


        @Synchronized
        fun getInstance(ctx: Context): UserDB {
            val tempInstance = instance
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val inst = Room.databaseBuilder(ctx.applicationContext, UserDB::class.java, "users").fallbackToDestructiveMigration()
                    .build()
                instance = inst
                return inst
            }
        }
    }
}

class Converters {

    @TypeConverter
    fun fromTimestamp(value: Long?): Date? {
        return if (value == null) null else Date(value)
    }

    @TypeConverter
    fun dateToTimestamp(date: Date?): Long? {
        return date?.time
    }

}