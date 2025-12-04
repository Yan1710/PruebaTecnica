package com.example.pruebatecnica.domain.model

data class Comment(
    val id: Int = 0,
    val postId: Int,
    val comment: String,
    val author: String
)
