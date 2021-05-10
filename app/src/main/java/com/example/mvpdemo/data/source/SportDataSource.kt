package com.example.mvpdemo.data.source

import com.example.mvpdemo.data.model.Sport
import com.example.mvpdemo.data.source.remote.OnFetchDataJsonListener

interface SportDataSource {
    /**
     * Local
     */

    /**
     * Remote
     */
    interface Remote {
        fun getSportList(listener: OnFetchDataJsonListener<MutableList<Sport>>)
    }
}
