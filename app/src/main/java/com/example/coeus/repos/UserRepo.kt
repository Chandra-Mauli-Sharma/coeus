package com.example.coeus.repos

import android.app.Application
import android.content.Context
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import androidx.lifecycle.LiveData
import com.example.coeus.dao.UserDAO
import com.example.coeus.db.UserDB
import com.example.coeus.model.UserEntity

class UserRepo(private val userDAO: UserDAO) {
    val getAllUsers: LiveData<List<UserEntity>> = userDAO.getUserDetails()
    suspend fun insert(user:UserEntity) = userDAO.insert(user)
}
