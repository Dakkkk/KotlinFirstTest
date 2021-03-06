package com.example.android.kotlinfirsttest.domain.model

/**
 * Created by Dawid on 2017-08-07.
 */
/*This file contains classes that provide objects for the UI like each list item Forecast*/
data class ForecastList(val city: String, val country: String,
                        val dailyForecast: List<Forecast>) {
    val size: Int
        get() = dailyForecast.size

    /*We use operator modifier to overload the get function, so we can get the dailyForecast[position] of type ForecastList more easily]*/
    operator fun get(position: Int): Forecast = dailyForecast[position]
}

/*This is the class that contains the data for each list item in our RecyclerView*/
data class Forecast(val date: String, val description: String, val high: Int, val low: Int, val iconUrl: String)