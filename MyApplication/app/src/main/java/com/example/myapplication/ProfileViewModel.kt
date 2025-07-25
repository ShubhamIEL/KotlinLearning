package com.example.myapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class ProfileViewModel : ViewModel() {
    private val _userName = MutableLiveData<String>()
    val userName: LiveData<String> = _userName

    private val _welcomeMsg = MutableLiveData<String>()
    val welcomeMsg: LiveData<String> = _welcomeMsg

    private val repository = ProfileRepository()
    init {
//        (userName as MutableLiveData).value ="USER NAME"
        //_userName.value ="!USER NAME!"
        updateUSerAfterDelay()
    }
    fun updateUSerAfterDelay(){
        viewModelScope.launch{
//            delay(2000)
//            _userName.value ="ALEX (updated)"
//            (userName as MutableLiveData).value = "ALEX (updated)"
            val updatedName = repository.fetchUpdatedUserName()
            _userName.value = updatedName
        }
    }
    fun updateUSer(name:String){
        val formattedMsg = getWelcomeMessage(name)
//        (welcomeMsg as MutableLiveData).value = formattedMsg
        _welcomeMsg.value =formattedMsg
    }
    private fun getWelcomeMessage(name: String):String{
        return  "Welcome , $name!"
    }
}