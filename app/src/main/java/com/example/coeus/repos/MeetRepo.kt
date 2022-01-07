package com.example.coeus.repos

import androidx.lifecycle.LiveData
import com.example.coeus.dao.MeetDao
import com.example.coeus.model.MeetEntity

class MeetRepo(private val meetDao: MeetDao) {
    val getMeets: LiveData<List<MeetEntity>> = meetDao.getMeets()
    suspend fun schedule(meet: MeetEntity) = meetDao.schedule(meet)
    suspend fun delete() = meetDao.delete()
}