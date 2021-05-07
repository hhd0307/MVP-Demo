package com.example.mvpdemo.data.source.remote.json

import android.os.AsyncTask
import com.example.mvpdemo.data.source.remote.OnFetchDataJsonListener
import org.json.JSONObject

class FetchData<T> (
        private val listener: OnFetchDataJsonListener<T>,
        private val keyEntity: String
): AsyncTask<String?, Unit, String?>() {

    private var exception: Exception? = null

    override fun doInBackground(vararg params: String?): String? {
        var result = ""
        try {
            result = Network.getJsonFromUrl(params[0]).toString()
        } catch (e: Exception){
            exception = e
        }
        return result
    }

    override fun onPostExecute(result: String?) {
        super.onPostExecute(result)
        if (!result.isNullOrBlank()){
            val jsonObject = JSONObject(result)
            @Suppress("UNCHECKED_CAST")
            listener.onSuccess(ParseJson().parseJsonArray(jsonObject) as T)
        } else listener.onError(exception)
    }
}
