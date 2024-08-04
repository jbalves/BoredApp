package com.example.boredapi.data.network.api

import com.example.boredapi.data.ActivityApi
import com.example.boredapi.data.network.responseobject.ActivityResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface ActivityRetrofitApi: ActivityApi {

    @GET("random")
    override suspend fun getRandomActivity(): ActivityResponse

    @GET("activity/{id}")
    override suspend fun getActivityByKey(@Path("id") key: Int): ActivityResponse
}