package com.example.pruebatecnica.data.remote

import com.example.pruebatecnica.data.model.Post
import retrofit2.http.GET

interface ApiService {
    @GET("posts")
    suspend fun getPost():List<Post>
}