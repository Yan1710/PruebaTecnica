package com.example.pruebatecnica.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.pruebatecnica.domain.usecase.GetPostsUseCase
import com.example.pruebatecnica.domain.usecase.SyncPostsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val syncPostsUseCase: SyncPostsUseCase,
    private val getPostsUseCase: GetPostsUseCase
) : ViewModel() {

    val posts = getPostsUseCase().asLiveData()

    fun refreshFromApi() {
        viewModelScope.launch { syncPostsUseCase() }
    }
}
