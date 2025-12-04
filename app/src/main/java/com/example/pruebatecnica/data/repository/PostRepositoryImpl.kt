package com.example.pruebatecnica.data.repository

import com.example.pruebatecnica.data.local.LocalDataSource
import com.example.pruebatecnica.data.mappers.toCommentEntity
import com.example.pruebatecnica.data.mappers.toDomainComment
import com.example.pruebatecnica.data.mappers.toPostEntity
import com.example.pruebatecnica.data.mappers.toDomainPost
import com.example.pruebatecnica.data.remote.PostRemoteDataSource
import com.example.pruebatecnica.domain.model.Comment
import com.example.pruebatecnica.domain.model.Post
import com.example.pruebatecnica.domain.repository.PostRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class PostRepositoryImpl @Inject constructor(
    private val remote: PostRemoteDataSource,
    private val local: LocalDataSource
) : PostRepository {

    override suspend fun syncPosts() {
        val dtos = remote.getPosts() // ahora existe getPosts()
        val entities = dtos.map { it.toPostEntity() }
        local.insertPosts(entities)
    }

    override fun getLocalPosts(): Flow<List<Post>> =
        local.getPosts().map { list -> list.map { it.toDomainPost() } }

    override suspend fun insertComment(comment: Comment) {
        local.insertComment(comment.toCommentEntity())
    }

    override fun getComments(postId: Int): Flow<List<Comment>> =
        local.getComments(postId).map { list -> list.map { it.toDomainComment() } }
}
