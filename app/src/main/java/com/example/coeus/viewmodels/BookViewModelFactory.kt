package com.example.coeus.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.coeus.repos.BooksRepo

class BookViewModelFactory(private val repo: BooksRepo):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if(modelClass.isAssignableFrom(BooksViewModel::class.java)){
            BooksViewModel(this.repo) as T
        }else{
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}