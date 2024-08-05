package com.example.boredapi.data.network

import com.example.boredapi.data.ActivityApi
import com.example.boredapi.data.network.mapper.ActivityDtoToActivityResponseMapper
import com.example.boredapi.data.network.responseobject.ActivityResponse

class ActivityRemoteDataSource(
    private val activityApi: ActivityApi,
    private val activityDtoToActivityResponseMapper: ActivityDtoToActivityResponseMapper
) {
    suspend fun getRandomActivity(): ActivityResponse =
        activityDtoToActivityResponseMapper.mapFromInput(activityApi.getRandomActivity())

    suspend fun getActivityByKey(key: Int): ActivityResponse =
        activityDtoToActivityResponseMapper.mapFromInput(activityApi.getActivityByKey(key))
}