package com.example.pruebatecnica.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pruebatecnica.data.model.Post
import com.example.pruebatecnica.domain.GetPostsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject
import kotlin.collections.emptyList

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getPostsUseCase: GetPostsUseCase
): ViewModel() {
    private val _post = MutableLiveData<List<Post>>()
    val post : LiveData<List<Post>> = _post

    fun loadPost(){
        viewModelScope.launch {
            val result = getPostsUseCase()
            _post.postValue(result)
        }
    }



}