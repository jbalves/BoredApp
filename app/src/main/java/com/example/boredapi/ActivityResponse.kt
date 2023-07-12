package com.example.boredapi

data class ActivityResponse (
    val activity: String,
    val accessibility: Float,
    val type: String,
    val participants: Int,
    val price: Float,
    val link: String,
    val key: String
)
