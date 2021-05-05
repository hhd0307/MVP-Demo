package com.example.mvpdemo.data.source.remote

import com.example.mvpdemo.data.model.Sport
import com.example.mvpdemo.data.source.SportDataSource
import com.example.mvpdemo.utils.Constant

class SportRemoteDataSource: SportDataSource.Remote {
    private var baseUrl = Constant.BASE_URL

    private object Holder {
        var INSTANCE = SportRemoteDataSource()
    }

    override fun getSportList(listener: OnFetchDataJsonListener<MutableList<Sport>>) {
        listener.onSuccess(mutableListOf(Sport(1,"test", "urlTest", "test repo response")))
    }

    companion object {
        val instance: SportRemoteDataSource by lazy { Holder.INSTANCE }
    }

}