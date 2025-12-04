package com.example.pruebatecnica.data.remote

import com.example.pruebatecnica.data.remote.dto.PostDto
import retrofit2.http.GET

interface ApiService {
    @GET("posts")
    suspend fun getPosts(): List<PostDto>
}
