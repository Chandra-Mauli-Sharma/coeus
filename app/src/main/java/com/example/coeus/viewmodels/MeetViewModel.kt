package com.example.coeus.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.coeus.db.UserDB
import com.example.coeus.model.MeetEntity
import com.example.coeus.repos.MeetRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MeetViewModel(app: Application): AndroidViewModel(app) {
    val allMeets: LiveData<List<MeetEntity>>
    private val repo: MeetRepo

    init {
        val meetDao = UserDB.getInstance(app).meetDao()
        repo = MeetRepo(meetDao)
        allMeets = repo.getMeets
    }

    fun schedule(meet:MeetEntity){
        viewModelScope.launch(Dispatchers.IO) {
            repo.schedule(meet)
        }
    }
}