package com.example.myapplication.feature_profile

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class ProfileRepository @Inject constructor(){
    fun fetchUpdatedUserNameStream(): Flow<String> = flow{
        delay(2000)
        emit("ALEX (from FLOW)")
    }.flowOn(Dispatchers.IO)


//    suspend fun fetchUpdatedUserName(): String{
////        delay(2000)
////        return "!! ALEX(FROM REPO) !!"
//        return withContext(Dispatchers.IO){
//            delay(2000)
//            "ALEX (from Repository/IO thread)"
//        }
//    }
}