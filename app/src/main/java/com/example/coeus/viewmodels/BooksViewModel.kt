package com.example.coeus.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.coeus.model.Book
import com.example.coeus.repos.BooksRepo
import kotlinx.coroutines.*

class BooksViewModel(private val repo: BooksRepo) : ViewModel() {
    val err = MutableLiveData<String>()
    val books = MutableLiveData<List<Book>>()
    var job: Job? = null
    val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        println("Exception handled: ${throwable.localizedMessage}")
    }

    val loading = MutableLiveData<Boolean>()

    fun getAllBooks() {
        val page = (1..20).random()
        job = CoroutineScope(Dispatchers.IO + exceptionHandler).launch {
            val response = repo.getAllBooks(page)
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    books.postValue(response.body()?.books!!)
                    loading.value = false
                } else {
                    println("Error in API")
                }
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }
}

