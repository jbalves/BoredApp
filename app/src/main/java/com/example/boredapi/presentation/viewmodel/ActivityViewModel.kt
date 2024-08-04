package com.example.boredapi.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.boredapi.data.network.responseobject.ActivityResponse
import com.example.boredapi.domain.ActivityRepository
import com.example.boredapi.presentation.ui.TAG
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ActivityViewModel @Inject constructor(
    private val repository: ActivityRepository
) : ViewModel() {

    private val _ramdomActivity = MutableLiveData<ActivityResponse>()
    val ramdomActivity: LiveData<ActivityResponse> get() = _ramdomActivity

    private val _activityByKey = MutableLiveData<ActivityResponse>()
    val activityByKey: LiveData<ActivityResponse> get() = _activityByKey

    fun getRandomActivity() {
        viewModelScope.launch {
            try {
                _ramdomActivity.value = repository.getRandomActivity()
            } catch (e: Exception) {
                // Handle the exception
                Log.d(TAG,"Exception: " + e.message)
            }
        }
    }

    fun getActivityByKey(key: Int) {
        viewModelScope.launch {
            try {
                _activityByKey.value = repository.getActivityByKey(key)
            } catch (e: Exception) {
                Log.d(TAG,"Exception: " + e.message)
            }
        }
    }
}