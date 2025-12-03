package com.example.pruebatecnica.data.remote

import javax.inject.Inject

class PostRemoteDataSource @Inject constructor(
    private val apiService: ApiService
) {
    suspend fun getPost() = apiService.getPost()
}