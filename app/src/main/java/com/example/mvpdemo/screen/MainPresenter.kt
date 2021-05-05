package com.example.mvpdemo.screen

import android.util.Log
import androidx.annotation.NonNull
import com.example.mvpdemo.data.model.Sport
import com.example.mvpdemo.data.source.SportRepository
import com.example.mvpdemo.data.source.remote.OnFetchDataJsonListener

const val TAG = "MainPresenter"
class MainPresenter internal constructor(private val repository: SportRepository?) : MainContract.Presenter {
    private var view: MainContract.View? = null

    override fun start() {
        getSports()
    }

    override fun setView(view: MainContract.View?) {
        this.setView(view)
    }

    override fun getSports() {
        repository?.getSports(object: OnFetchDataJsonListener<MutableList<Sport>>{
            override fun onSuccess(data: MutableList<Sport>) {
                Log.d(TAG, "onSuccess: ${data.size}")
            }

            override fun onError(exception: Exception?) {
                Log.e(TAG, "onError: $exception")
            }

        })
    }
}