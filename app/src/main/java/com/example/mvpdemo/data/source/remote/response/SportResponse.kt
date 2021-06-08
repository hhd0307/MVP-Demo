package com.example.mvpdemo.data.source.remote.response

import com.example.mvpdemo.data.model.Sport
import com.google.gson.annotations.SerializedName

class SportResponse {
    @SerializedName("sports")
    lateinit var sportItems: List<Sport>
}