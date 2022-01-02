package com.example.coeus.repos

import com.example.coeus.api.BookApiInterface

class BooksRepo(private val retrofitService:BookApiInterface) {
    suspend fun getAllBooks() = retrofitService.getBooks()
}