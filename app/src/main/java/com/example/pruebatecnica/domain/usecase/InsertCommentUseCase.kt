package com.example.pruebatecnica.domain.usecase

import com.example.pruebatecnica.domain.model.Comment
import com.example.pruebatecnica.domain.repository.PostRepository
import javax.inject.Inject

class InsertCommentUseCase @Inject constructor(private val repo: PostRepository) {
    suspend operator fun invoke(comment: Comment) = repo.insertComment(comment)
}
