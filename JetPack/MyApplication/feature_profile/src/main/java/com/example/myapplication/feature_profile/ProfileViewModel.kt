package com.example.myapplication.feature_profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val repository: ProfileRepository
) : ViewModel() {

    private val _userName = MutableStateFlow("User NAME")
    val userName: StateFlow<String> = _userName.asStateFlow()

    private val _isLoading = MutableStateFlow(true)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    private val _history = MutableLiveData<List<String>>(emptyList())
    val history: LiveData<List<String>> = _history

    init {
        addHistoryItem(_userName.value)
        viewModelScope.launch {
            delay(2000)
            fetchUpdatedUser()
        }
    }

    private fun addHistoryItem(item: String) {
        val currentList = _history.value ?: emptyList()
        val newList = currentList.toMutableList().apply {
            add(0, item)
        }
        _history.value = newList
    }

    fun fetchUpdatedUser() {
        viewModelScope.launch {
            _isLoading.value = true
            repository.fetchUpdatedUserNameStream().collect { updatedName ->
                _userName.value = updatedName
                addHistoryItem(updatedName)
                _isLoading.value = false
            }
        }
    }

    fun updateUserWithDelay(name: String) {
        viewModelScope.launch {
            _isLoading.value = true
            delay(2000)
            _userName.value = name
            addHistoryItem(name)
            _isLoading.value = false
        }
    }
}