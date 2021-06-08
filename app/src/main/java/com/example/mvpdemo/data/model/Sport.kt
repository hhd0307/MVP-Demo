package com.example.mvpdemo.data.model

import com.google.gson.annotations.SerializedName

data class Sport(
    @SerializedName("idSport")
    val id: Int?,
    @SerializedName("strSport")
    val name: String?,
    @SerializedName("strSportThumb")
    val thumbnail: String?,
    @SerializedName("strSportDescription")
    val description: String?
)
