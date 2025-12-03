package com.example.pruebatecnica.data.repository

import com.example.pruebatecnica.data.model.Post
import com.example.pruebatecnica.data.remote.PostRemoteDataSource
import javax.inject.Inject

class PostRespository @Inject constructor(
    private val remoteDataSource: PostRemoteDataSource
) {
    suspend fun getPost(): List<Post> = remoteDataSource.getPost()
}