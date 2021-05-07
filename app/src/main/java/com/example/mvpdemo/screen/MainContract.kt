package com.example.mvpdemo.screen

import com.example.mvpdemo.base.BasePresenter
import com.example.mvpdemo.data.model.Sport

interface MainContract {
    /**
     * View
     */
    interface View {
        fun showSports(sports: MutableList<Sport>)

        fun showErrorLoading(exception: Exception?)
    }

    /**
     * Presenter
     */
    interface Presenter:BasePresenter<View> {
        fun getSports()
    }
}
