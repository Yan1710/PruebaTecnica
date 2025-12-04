package com.example.pruebatecnica.domain.usecase

import com.example.pruebatecnica.domain.repository.PostRepository
import javax.inject.Inject

class SyncPostsUseCase @Inject constructor(private val repo: PostRepository) {
    suspend operator fun invoke() = repo.syncPosts()
}
