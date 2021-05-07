package com.example.mvpdemo.data.source

import com.example.mvpdemo.data.model.Sport
import com.example.mvpdemo.data.source.remote.OnFetchDataJsonListener
import com.example.mvpdemo.data.source.remote.SportRemoteDataSource

class SportRepository private constructor(private val remote: SportDataSource.Remote){
    private object Holder {
        val INSTANCE = SportRepository(remote = SportRemoteDataSource.instance)
    }

    fun getSports(listener: OnFetchDataJsonListener<MutableList<Sport>>) {
        remote.getSportList(listener)
    }

    companion object {
        val instance: SportRepository by lazy { Holder.INSTANCE }
    }
}
