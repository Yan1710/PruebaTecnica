package com.example.pruebatecnica.domain

import com.example.pruebatecnica.data.repository.PostRespository
import javax.inject.Inject

class GetPostsUseCase @Inject constructor(
    private val respository: PostRespository
) {
    suspend operator fun invoke() =respository.getPost()
}