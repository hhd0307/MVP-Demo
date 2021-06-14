package com.example.mvpdemo.screen

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.example.mvpdemo.data.model.Sport

class ItemSportViewModel : BaseObservable() {

    var sport: Sport? = null
        set(value) {
            field = value
            notifyChange()
        }
    @get: Bindable
    val name: String? get() = sport?.name
    @get: Bindable
    val image: String? get() = sport?.thumbnail
}