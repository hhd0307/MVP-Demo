package com.example.mvpdemo.data.source.remote

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mvpdemo.data.model.Sport
import com.example.mvpdemo.data.source.remote.api.ApiService
import com.example.mvpdemo.data.source.remote.response.SportResponse
import com.example.mvpdemo.utils.Constant
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


private const val TAG = "DataFetcher"

class DataFetcher {

    private val sportApi: ApiService

    init {
        val okHttpClient = OkHttpClient.Builder()
            .connectTimeout(TIME_OUT, TimeUnit.MILLISECONDS)
            .readTimeout(TIME_OUT, TimeUnit.MILLISECONDS)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(Constant.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        sportApi = retrofit.create(ApiService::class.java)
    }

    fun fetchContents(): LiveData<List<Sport>> {
        val responseLiveData: MutableLiveData<List<Sport>> = MutableLiveData()
        val request = sportApi.fetchSports()

        request.enqueue(object : Callback<SportResponse> {
            override fun onFailure(call: Call<SportResponse>, t: Throwable) {
                Log.e(TAG, "Failed to fetch sports", t)
            }

            override fun onResponse(call: Call<SportResponse>, response: Response<SportResponse>) {
                val sportResponse = response.body()
                val sportItems = sportResponse?.sportItems ?: mutableListOf()
                responseLiveData.value = sportItems
            }
        })

        return responseLiveData
    }

    companion object {
        private const val TIME_OUT = 20000L
    }
}