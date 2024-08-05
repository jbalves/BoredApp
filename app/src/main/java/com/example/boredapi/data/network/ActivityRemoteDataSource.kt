package com.example.boredapi.data.network

import com.example.boredapi.data.ActivityApi
import com.example.boredapi.data.network.dto.ActivityDto
import com.example.boredapi.data.network.mapper.ActivityMapper
import com.example.boredapi.data.network.responseobject.ActivityResponse

class ActivityRemoteDataSource(
    private val activityApi: ActivityApi,
    private val activityMapper: ActivityMapper
) {
    suspend fun getRandomActivity(): ActivityResponse =
        activityMapper.mapFromInput(activityApi.getRandomActivity())

    suspend fun getActivityByKey(key: Int): ActivityResponse =
        activityMapper.mapFromInput(activityApi.getActivityByKey(key))
}