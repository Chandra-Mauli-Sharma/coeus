package com.example.coeus.repos

import androidx.lifecycle.LiveData
import com.example.coeus.dao.UserDAO
import com.example.coeus.model.UserEntity

class UserRepo(private val userDAO: UserDAO) {
    val getAllUsers: LiveData<List<UserEntity>> = userDAO.getUserDetails()
    suspend fun insert(user:UserEntity) = userDAO.insert(user)
    suspend fun delete() = userDAO.delete()
}
