package com.example.boredapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {
    private lateinit var txtId:TextView
    private val apiService = ApiClient.craete()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtId = findViewById(R.id.txtId)
        getMydata();
    }

    private fun getMydata() {
        val call = apiService.getRandomActivity()

        call.enqueue(object : Callback<ActivityResponse> {
            override fun onResponse(call: Call<ActivityResponse>, response: Response<ActivityResponse>) {
                val responseBody = response.body()
               txtId.text = responseBody?.activity ?: "Nothing activity founded"
            }

            override fun onFailure(call: Call<ActivityResponse>, t: Throwable) {
                Log.d("MainActivity","onFailure: " + t.message)
                txtId.text = "Fail when called API: ${t.message}"
            }
        })
    }
}