package com.example.mvpdemo.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter

object BindingUtils {
    @JvmStatic
    @BindingAdapter("app:imageUrl")
    fun ImageView.setImageUrl(url: String?) {
        url?.let {
            this.loadImage(it)
        }
    }
}