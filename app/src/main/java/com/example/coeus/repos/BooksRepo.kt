package com.example.coeus.repos

import com.example.coeus.api.BookApiInterface

class BooksRepo(private val retrofitService:BookApiInterface) {
    suspend fun getAllBooks(page: Int) = retrofitService.getBooks(page)
}