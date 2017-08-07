package com.example.android.kotlinfirsttest.domain.model

/**
 * Created by Dawid on 2017-08-07.
 */
data class ForecastList(val city: String, val country: String, val dailyForecast: List<Forecast>)
data class Forecast(val date: String, val description: String, val high: Int, val low: Int)