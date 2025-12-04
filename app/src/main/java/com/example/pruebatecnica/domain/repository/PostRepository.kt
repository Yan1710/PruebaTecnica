package com.example.pruebatecnica.domain.repository

import com.example.pruebatecnica.domain.model.Comment
import com.example.pruebatecnica.domain.model.Post
import kotlinx.coroutines.flow.Flow

interface PostRepository {
    suspend fun syncPosts()
    fun getLocalPosts(): Flow<List<Post>>
    suspend fun insertComment(comment: Comment)
    fun getComments(postId: Int): Flow<List<Comment>>
}
