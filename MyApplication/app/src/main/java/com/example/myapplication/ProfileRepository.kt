package com.example.myapplication

import kotlinx.coroutines.delay

class ProfileRepository {
    suspend fun fetchUpdatedUserName(): String{
        delay(2000)
        return "!! ALEX(FROM REPO) !!"
    }
}