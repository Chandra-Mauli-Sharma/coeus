package com.example.coeus.api

import com.example.coeus.model.BookResponse
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

const val BASE_URL = "https://api.itbook.store/1.0/"

interface BookApiInterface {

    @GET("search/Information&Technology")
    suspend fun getBooks(): Response<BookResponse>

    companion object{
        var retrofit: BookApiInterface? = null
        fun getInstance():BookApiInterface {
            if(retrofit==null){
                val retro = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                retrofit = retro.create(BookApiInterface::class.java)
            }
            return retrofit!!
        }
    }
}