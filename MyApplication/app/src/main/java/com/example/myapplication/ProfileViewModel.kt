package com.example.myapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class ProfileViewModel : ViewModel() {
    val userName: LiveData<String> =MutableLiveData()

    init {
        (userName as MutableLiveData).value ="USER NAME"
    }
    fun updateUSerAfterDelay(){
        viewModelScope.launch{
            delay(2000)

            (userName as MutableLiveData).value = "ALEX (updated)"
        }
    }
}