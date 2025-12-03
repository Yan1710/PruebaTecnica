package com.example.pruebatecnica.data.room.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "comments",
    foreignKeys = [
        ForeignKey(
            entity = PostEntity::class,
            parentColumns = ["id"],
            childColumns = ["postId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class CommentEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val postId: Int,
    val text: String
)
