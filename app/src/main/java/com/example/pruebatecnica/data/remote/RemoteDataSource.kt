package com.example.pruebatecnica.data.remote

import com.example.pruebatecnica.data.remote.dto.PostDto
import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    private val api: ApiService
) {
    suspend fun getPosts() = api.getPosts()
}