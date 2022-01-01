package com.example.coeus.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.coeus.db.UserDB
import com.example.coeus.model.UserEntity
import com.example.coeus.repos.UserRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(app:Application):AndroidViewModel(app) {
    val allUsers:LiveData<List<UserEntity>>
    private val repo:UserRepo

    init {
        val userDao = UserDB.getInstance(app).userDao()
        repo = UserRepo(userDao)
        allUsers = repo.getAllUsers
    }

    fun insert(user:UserEntity){
        viewModelScope.launch(Dispatchers.IO) {
            repo.insert(user)
        }
    }
    fun delete(){
        viewModelScope.launch(Dispatchers.IO) {
            repo.delete()
        }
    }
}