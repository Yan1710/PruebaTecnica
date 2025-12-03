package com.example.pruebatecnica.data.room.Daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.pruebatecnica.data.room.entity.CommentEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CommentDao {

    @Insert
    suspend fun insertComment(comment: CommentEntity)

    @Query("SELECT * FROM comments WHERE postId = :postId")
    fun getComments(postId: Int): Flow<List<CommentEntity>>
}