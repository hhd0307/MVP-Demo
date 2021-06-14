package com.example.mvpdemo.screen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import com.example.mvpdemo.R
import com.example.mvpdemo.data.model.Sport
import com.example.mvpdemo.data.source.remote.DataFetcher

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {

    lateinit var  fragment: SportsFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView(savedInstanceState)
        initData()
    }

    private fun initView(savedInstanceState: Bundle?) {
        fragment = SportsFragment.newInstance()
        val isFragmentContainerEmpty = savedInstanceState == null
        if (isFragmentContainerEmpty) {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragmentContainer, fragment)
                .commit()
        }
    }

    private fun initData() {
    }
}
