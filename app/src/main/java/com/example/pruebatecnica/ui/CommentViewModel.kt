package com.example.pruebatecnica.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.pruebatecnica.domain.model.Comment
import com.example.pruebatecnica.domain.usecase.GetCommentsUseCase
import com.example.pruebatecnica.domain.usecase.InsertCommentUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CommentViewModel @Inject constructor(
    private val insertCommentUseCase: InsertCommentUseCase,
    private val getCommentsUseCase: GetCommentsUseCase
) : ViewModel() {

    fun addComment(postId: Int, commentText: String, author: String = "Anon") {
        viewModelScope.launch {
            insertCommentUseCase(Comment(postId = postId, comment = commentText, author = author))
        }
    }

    fun getComments(postId: Int) = getCommentsUseCase(postId).asLiveData()
}
