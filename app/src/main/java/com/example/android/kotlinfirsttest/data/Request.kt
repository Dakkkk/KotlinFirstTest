package com.example.android.kotlinfirsttest.data

import android.util.Log
import java.net.URL

/**
 * Created by Dawid on 2017-08-07.
 */
class Request(val url: String) {

    fun run() {
        val forecastJsonStr = URL(url).readText()
        Log.d(javaClass.simpleName, forecastJsonStr)
    }

}