package com.example.mvpdemo.base

interface BasePresenter<T> {
    fun start()
    fun setView(view: T?)
}