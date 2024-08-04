package com.example.boredapi.data.repository

import com.example.boredapi.data.network.ActivityRemoteDataSource
import com.example.boredapi.data.network.responseobject.ActivityResponse
import com.example.boredapi.domain.ActivityRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ActivityRepositoryImpl(
    private val activityRemoteDataSource: ActivityRemoteDataSource,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
): ActivityRepository {
    override suspend fun getRandomActivity(): ActivityResponse {
        return withContext(dispatcher) {
            activityRemoteDataSource.getRandomActivity()
        }
    }

    override suspend fun getActivityByKey(key: Int): ActivityResponse {
        return withContext(dispatcher) {
            activityRemoteDataSource.getActivityByKey(key = key)
        }

    }
}