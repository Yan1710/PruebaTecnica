package com.example.pruebatecnica.data.remote

import com.example.pruebatecnica.data.remote.dto.PostDto
import javax.inject.Inject

class PostRemoteDataSource @Inject constructor(
    private val apiService: ApiService
) {
    // nombre explícito y consistente con ApiService
    suspend fun getPosts(): List<PostDto> = apiService.getPosts()
}
