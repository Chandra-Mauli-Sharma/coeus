package com.example.coeus.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.coeus.model.MeetEntity

@Dao
interface MeetDao {
    @Insert
    suspend fun schedule(meet:MeetEntity)

    @Query("select * from meets")
    fun getMeets(): LiveData<List<MeetEntity>>

    @Query("DELETE FROM meets")
    suspend fun delete()
}