package com.example.mvpdemo.screen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.mvpdemo.R
import com.example.mvpdemo.data.model.Sport
import com.example.mvpdemo.data.source.SportRepository
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainContract.View {

    private val mainAdapter by lazy {
        MainAdapter {showDetailDialog(it)}
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        initData()
    }

    override fun showSports(sports: MutableList<Sport>) {
        mainAdapter.updateData(sports)
    }

    override fun showErrorLoading(exception: Exception?) {
        Toast.makeText(applicationContext, "Loading error: $exception", Toast.LENGTH_SHORT).show()
    }

    private fun initView() {
        recyclerSport.apply {
            setHasFixedSize(true)
            adapter = mainAdapter
        }
    }

    private fun initData() {
        val mainPresenter = MainPresenter(SportRepository.instance)
        mainPresenter.run {
            setView(this@MainActivity)
            start()
        }
    }

    private fun showDetailDialog(it: Sport) {
        AlertDialog.Builder(this)
            .setTitle(it.name)
            .setMessage(it.description)
            .setPositiveButton("OK", null)
            .setCancelable(true)
            .show()
    }
}
