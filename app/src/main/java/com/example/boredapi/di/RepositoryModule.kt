package com.example.boredapi.di

import com.example.boredapi.data.ActivityApi
import com.example.boredapi.data.network.ActivityRemoteDataSource
import com.example.boredapi.data.network.mapper.ActivityDtoToActivityResponseMapper
import com.example.boredapi.data.repository.ActivityRepositoryImpl
import com.example.boredapi.domain.ActivityRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideActivityRemoteDataSource(
        activityApi: ActivityApi,
        activityDtoToActivityResponseMapper: ActivityDtoToActivityResponseMapper
    ): ActivityRemoteDataSource {
        return ActivityRemoteDataSource(
            activityApi,
            activityDtoToActivityResponseMapper
        )
    }

    @Provides
    @Singleton
    fun provideActivityRepository(
        remoteDataSource: ActivityRemoteDataSource
    ): ActivityRepository {
        return ActivityRepositoryImpl(remoteDataSource)
    }
}