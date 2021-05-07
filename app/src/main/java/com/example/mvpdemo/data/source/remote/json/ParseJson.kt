package com.example.mvpdemo.data.source.remote.json

import com.example.mvpdemo.data.model.Sport
import com.example.mvpdemo.data.model.SportEntry
import org.json.JSONObject

class ParseJson {
    private fun parseJsonSport(jsonObject: JSONObject): Sport {
        with(jsonObject) {
            return Sport(
                    getInt(SportEntry.ID),
                    getString(SportEntry.NAME),
                    getString(SportEntry.THUMBNAIL),
                    getString(SportEntry.DESCRIPTION)
            )
        }
    }

    fun parseJsonArray(jsonObject: JSONObject): MutableList<Sport> {
        val data: MutableList<Sport> = mutableListOf()
        jsonObject.getJSONArray(SportEntry.OBJECT).let { array ->
            for (it in 0 until array.length()) {
                data.add(parseJsonSport(array.getJSONObject(it)))
            }
        }
        return data
    }
}