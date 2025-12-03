package com.example.pruebatecnica.data.room

import com.example.pruebatecnica.data.room.Daos.CommentDao
import com.example.pruebatecnica.data.room.Daos.PostDao
import com.example.pruebatecnica.data.room.entity.CommentEntity
import com.example.pruebatecnica.data.room.entity.PostEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalDataSource @Inject constructor(
    private val postDao: PostDao,
    private val commentDao: CommentDao
) {

    suspend fun insertPosts(posts: List<PostEntity>) =
        postDao.insertPosts(posts)

    fun getPosts(): Flow<List<PostEntity>> =
        postDao.getPosts()

    suspend fun insertComment(comment: CommentEntity) =
        commentDao.insertComment(comment)

    fun getComments(postId: Int): Flow<List<CommentEntity>> =
        commentDao.getComments(postId)
}
