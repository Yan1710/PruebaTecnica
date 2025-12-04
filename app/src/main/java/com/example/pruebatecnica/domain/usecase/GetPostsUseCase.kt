package com.example.pruebatecnica.domain.usecase

import com.example.pruebatecnica.domain.model.Post
import com.example.pruebatecnica.domain.repository.PostRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPostsUseCase @Inject constructor(private val repo: PostRepository) {
    operator fun invoke(): Flow<List<Post>> = repo.getLocalPosts()
}
