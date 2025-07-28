package com.example.myapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(private val repository: ProfileRepository
) : ViewModel() {
    private val _userName = MutableLiveData<String>()
    val userName: LiveData<String> = _userName

    private val _welcomeMsg = MutableLiveData<String>()
    val welcomeMsg: LiveData<String> = _welcomeMsg

   // private val repository = ProfileRepository()

    private val _history = MutableLiveData<List<String>>(emptyList())
    val history : LiveData<List<String>> = _history
    init{
        val initialUser ="User NAME"
        _userName.value =initialUser
        addHistoryItem(initialUser)
        viewModelScope.launch {
            delay(2000)
            fetchUpdatedUser()
        }
       // fetchUpdatedUser()
    }
    fun fetchInitialUSer(){
        val initialUser = "initial"
        _userName.value = initialUser
        addHistoryItem(initialUser)
    }

    private fun addHistoryItem(item: String) {
        val currentList = _history.value ?: emptyList()
        val newList =currentList.toMutableList().apply {
            add(0, item)
        }
        _history.value = newList
    }

    fun fetchUpdatedUser(){
        viewModelScope.launch {
            repository.fetchUpdatedUserNameStream()
                .collect{ updatedName->
                    _userName.value =updatedName
                    addHistoryItem(updatedName)
                }

//            val updatedName = repository.fetchUpdatedUserName()
//            _userName.value = updatedName
//
//            addHistoryItem(updatedName)
        }
    }
    fun updateUserWithDelay(name: String) {
        viewModelScope.launch {
            delay(2000)
            _userName.value = name
            addHistoryItem(name)
        }
    }

    fun updateUserWithName(name: String) {
        _userName.value = name
    }

}
//    init {
////        (userName as MutableLiveData).value ="USER NAME"
//        //_userName.value ="!USER NAME!"
//        updateUSerAfterDelay()
//    }
//    fun updateUSerAfterDelay(){
//        viewModelScope.launch{
////            delay(2000)
////            _userName.value ="ALEX (updated)"
////            (userName as MutableLiveData).value = "ALEX (updated)"
//            val updatedName = repository.fetchUpdatedUserName()
//            _userName.value = updatedName
//        }
//    }
//    fun updateUSer(name:String){
//        val formattedMsg = getWelcomeMessage(name)
////        (welcomeMsg as MutableLiveData).value = formattedMsg
//        _welcomeMsg.value =formattedMsg
//    }
//    private fun getWelcomeMessage(name: String):String{
//        return  "Welcome , $name!"
//    }
//}