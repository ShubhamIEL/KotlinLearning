package com.example.myapplication

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class ProfileRepository {
    suspend fun fetchUpdatedUserName(): String{
//        delay(2000)
//        return "!! ALEX(FROM REPO) !!"
        return withContext(Dispatchers.IO){
            delay(2000)
            "ALEX (from Repository/IO thread)"
        }
    }
}