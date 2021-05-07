package com.example.mvpdemo.screen

import com.example.mvpdemo.data.model.Sport
import com.example.mvpdemo.data.source.SportRepository
import com.example.mvpdemo.data.source.remote.OnFetchDataJsonListener

class MainPresenter internal constructor(private val repository: SportRepository?) : MainContract.Presenter {

    private var view: MainContract.View? = null

    override fun start() {
        getSports()
    }

    override fun setView(view: MainContract.View?) {
        this.view = view
    }

    override fun getSports() {
        repository?.getSports(object : OnFetchDataJsonListener<MutableList<Sport>> {
            override fun onSuccess(data: MutableList<Sport>) {
                view?.showSports(data)
            }

            override fun onError(exception: Exception?) {
                view?.showErrorLoading(exception)
            }
        })
    }
}
