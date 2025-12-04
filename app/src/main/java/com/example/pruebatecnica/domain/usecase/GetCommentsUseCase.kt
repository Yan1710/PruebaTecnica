package com.example.pruebatecnica.domain.usecase

import com.example.pruebatecnica.domain.model.Comment
import com.example.pruebatecnica.domain.repository.PostRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCommentsUseCase @Inject constructor(private val repo: PostRepository) {
    operator fun invoke(postId: Int): Flow<List<Comment>> = repo.getComments(postId)
}
