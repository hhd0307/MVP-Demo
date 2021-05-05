package com.example.mvpdemo.data.model

data class Sport(
        val id: Int,
        val name: String,
        val thumbnail: String,
        val description: String
)

object SportEntry {
    const val OBJECT = "sports"
    const val ID = "idSport"
    const val NAME = "strSport"
    const val THUMBNAIL = "strSportThumb"
    const val DESCRIPTION = "strSportDescription"
}