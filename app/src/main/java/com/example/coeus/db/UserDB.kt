package com.example.coeus.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.coeus.dao.UserDAO
import com.example.coeus.model.UserEntity

@Database(entities = [UserEntity::class], version = 1)
abstract class UserDB : RoomDatabase() {
    abstract fun userDao(): UserDAO

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
                val inst = Room.databaseBuilder(ctx.applicationContext, UserDB::class.java, "users")
                    .build()
                instance = inst
                return inst
            }
        }
    }
}