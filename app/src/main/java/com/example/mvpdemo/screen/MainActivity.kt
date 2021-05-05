package com.example.mvpdemo.screen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mvpdemo.R
import com.example.mvpdemo.data.source.SportRepository

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
        val presenter = MainPresenter(SportRepository.instance)
//        presenter.setView(this)
        presenter.start()
    }
}