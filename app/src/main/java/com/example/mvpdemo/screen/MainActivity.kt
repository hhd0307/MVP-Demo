package com.example.mvpdemo.screen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import com.example.mvpdemo.R
import com.example.mvpdemo.data.source.remote.DataFetcher

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        initData()
    }

    private fun initView() {
    }

    private fun initData() {
        val sportLiveData = DataFetcher().fetchContents()
        sportLiveData.observe(this, Observer {
            Log.d(TAG, "Main activity receive: $it")
        })
    }
}
