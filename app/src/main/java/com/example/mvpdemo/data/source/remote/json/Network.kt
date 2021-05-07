package com.example.mvpdemo.data.source.remote.json

import com.example.mvpdemo.utils.Constant.METHOD_GET
import com.example.mvpdemo.utils.Constant.TIME_OUT
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class Network {

    companion object {
        fun getJsonFromUrl(strUrl: String?): String?{
            val url = URL(strUrl)
            val httpURLConnection = url.openConnection() as HttpURLConnection
            httpURLConnection.run {
                connectTimeout = TIME_OUT
                readTimeout = TIME_OUT
                requestMethod = METHOD_GET
                connect()
            }

            val bufferedReader = BufferedReader(InputStreamReader(url.openStream()))
            val stringBuilder = StringBuilder()
            var line: String?
            while (bufferedReader.readLine().also { line = it } != null) {
                stringBuilder.append(line)
            }
            bufferedReader.close()
            httpURLConnection.disconnect()
            return stringBuilder.toString()
        }
    }
}
