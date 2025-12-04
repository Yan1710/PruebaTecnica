package com.example.pruebatecnica.data.mappers

import com.example.pruebatecnica.data.local.entity.PostEntity
import com.example.pruebatecnica.data.remote.dto.PostDto
import com.example.pruebatecnica.domain.model.Post

fun PostDto.toPostEntity() = PostEntity(
    id = id,
    userId = userId,
    title = title,
    body = body
)

fun PostEntity.toDomainPost() = Post(
    id = id,
    userId = userId,
    title = title,
    body = body
)
