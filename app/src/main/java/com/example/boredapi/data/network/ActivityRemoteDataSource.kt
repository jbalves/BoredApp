package com.example.boredapi.data.network

import com.example.boredapi.data.ActivityApi
import com.example.boredapi.data.network.responseobject.ActivityResponse

class ActivityRemoteDataSource(
    private val activityApi: ActivityApi
) {
    suspend fun getRandomActivity(): ActivityResponse = activityApi.getRandomActivity()
    suspend fun getActivityByKey(key: Int): ActivityResponse = activityApi.getActivityByKey(key)
}