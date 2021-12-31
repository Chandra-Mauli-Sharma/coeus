package com.example.coeus.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.coeus.model.UserEntity

@Dao
interface UserDAO {
    @Insert
    suspend fun insert(user:UserEntity)

    @Query("select * from users order by id desc")
    fun getUserDetails(): LiveData<List<UserEntity>>
}