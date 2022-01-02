package com.example.coeus.model

import com.google.gson.annotations.SerializedName

data class BookResponse(
    val books: List<Book>,
    val error: String,
    val page: String,
    val total: String
)