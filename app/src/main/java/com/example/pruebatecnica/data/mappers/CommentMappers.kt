package com.example.pruebatecnica.data.mappers

import com.example.pruebatecnica.data.local.entity.CommentEntity
import com.example.pruebatecnica.domain.model.Comment

fun CommentEntity.toDomainComment() = Comment(
    id = id,
    postId = postId,
    comment = comment,
    author = author
)

fun Comment.toCommentEntity() = CommentEntity(
    id = id,
    postId = postId,
    comment = comment,
    author = author
)
