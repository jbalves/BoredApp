package com.example.boredapi.presentation.ui

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.boredapi.R
import com.example.boredapi.presentation.viewmodel.ActivityViewModel
import dagger.hilt.android.AndroidEntryPoint

const val TAG = "BoredApiApp"

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: ActivityViewModel by viewModels()

    private lateinit var txtId:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtId = findViewById(R.id.txtId)

        viewModel.ramdomActivity.observe(this) { activityResponse  ->
            // Handle the list of random activities here
            // Example: Update the UI or log the activities
            txtId.text = activityResponse.activity
            Log.d(TAG, "Random Activities: $activityResponse ")
        }

        viewModel.activityByKey.observe(this) { activityResponse  ->
            // Update the UI with the activity data
            txtId.text = activityResponse.activity ?: "Nothing activity found"
            Log.d(TAG, "Activity by Key: $activityResponse")
        }

        fetchData()
    }

    private fun fetchData() {
        viewModel.getRandomActivity()
        viewModel.getActivityByKey(3943506)
    }
}