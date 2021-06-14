package com.example.mvpdemo.screen

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.mvpdemo.data.model.Sport
import com.example.mvpdemo.data.source.remote.DataFetcher

class SportViewModel : ViewModel() {

    val sportLiveData: LiveData<List<Sport>>

    init {
        sportLiveData = DataFetcher().fetchSports()
    }
}