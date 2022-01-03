package com.example.coeus.model

data class BookResponse(
    val books: List<Book>,
    val error: String,
    val page: String,
    val total: String
)