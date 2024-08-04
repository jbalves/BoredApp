package com.example.boredapi.data

import com.example.boredapi.data.network.responseobject.ActivityResponse

interface ActivityApi {

    suspend fun getRandomActivity(): ActivityResponse

    suspend fun getActivityByKey(key: Int): ActivityResponse
}