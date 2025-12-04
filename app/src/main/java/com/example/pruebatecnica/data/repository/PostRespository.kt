package com.example.pruebatecnica.data.repository

import com.example.pruebatecnica.data.model.Post
import com.example.pruebatecnica.data.remote.PostRemoteDataSource
import com.example.pruebatecnica.data.remote.dto.PostDto
import javax.inject.Inject

class PostRespository @Inject constructor(
    private val remoteDataSource: PostRemoteDataSource
) {
    suspend fun getPost(): List<PostDto> = remoteDataSource.getPosts()
}