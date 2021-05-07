package com.example.mvpdemo.screen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvpdemo.R
import com.example.mvpdemo.data.model.Sport
import com.example.mvpdemo.data.source.SportRepository
import com.example.mvpdemo.utils.OnItemRecyclerViewClickListener
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainContract.View, OnItemRecyclerViewClickListener<Sport> {
    private val mainAdapter by lazy { MainAdapter() }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        initData()
    }

    private fun initView() {
        recyclerSport.apply {
            layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
            setHasFixedSize(true)
            adapter = mainAdapter
        }
        mainAdapter.registerItemRecyclerViewClickListener(this)
    }

    private fun initData() {
        val mainPresenter = MainPresenter(SportRepository.instance)
        mainPresenter.run {
            setView(this@MainActivity)
            start()
        }
    }

    override fun showSports(sports: MutableList<Sport>) {
        mainAdapter.updateData(sports)
    }

    override fun showErrorLoading(exception: Exception?) {
        Toast.makeText(applicationContext, "Loading error: $exception", Toast.LENGTH_SHORT).show()
    }

    override fun onItemClickListener(item: Sport?) {
        AlertDialog.Builder(this)
                .setTitle(item?.name)
                .setMessage(item?.description)
                .setPositiveButton("OK", null)
                .setCancelable(true)
                .show()
    }
}