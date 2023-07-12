package com.example.boredapi

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("activity/")
    fun getRandomActivity(): Call<ActivityResponse>
}