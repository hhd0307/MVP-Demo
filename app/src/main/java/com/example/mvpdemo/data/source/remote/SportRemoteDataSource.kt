package com.example.mvpdemo.data.source.remote

import com.example.mvpdemo.data.model.Sport
import com.example.mvpdemo.data.model.SportEntry
import com.example.mvpdemo.data.source.SportDataSource
import com.example.mvpdemo.data.source.remote.json.FetchData
import com.example.mvpdemo.utils.Constant

class SportRemoteDataSource: SportDataSource.Remote {
    private var baseUrl = Constant.BASE_URL

    private object Holder {
        var INSTANCE = SportRemoteDataSource()
    }

    override fun getSportList(listener: OnFetchDataJsonListener<MutableList<Sport>>) {
        FetchData(listener, SportEntry.OBJECT).execute(baseUrl)
    }

    companion object {
        val instance: SportRemoteDataSource by lazy { Holder.INSTANCE }
    }

}