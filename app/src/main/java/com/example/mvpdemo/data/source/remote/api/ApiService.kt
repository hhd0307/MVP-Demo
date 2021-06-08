package com.example.mvpdemo.data.source.remote.api

import com.example.mvpdemo.data.source.remote.response.SportResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("api/v1/json/1/all_sports.php")
    fun fetchSports(): Call<SportResponse>
}