package com.example.boredapi.domain

import com.example.boredapi.data.network.responseobject.ActivityResponse

interface ActivityRepository {
    suspend fun getRandomActivity(): ActivityResponse
    suspend fun getActivityByKey(key: Int): ActivityResponse
}