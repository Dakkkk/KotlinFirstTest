package com.example.android.kotlinfirsttest.domain.commands

import com.example.android.kotlinfirsttest.data.ForecastRequest
import com.example.android.kotlinfirsttest.domain.mappers.ForecastDataMapper
import com.example.android.kotlinfirsttest.domain.model.ForecastList

/**
 * Created by Dawid on 2017-08-09.
 */
/*Class used to build the forecast request using the given zip code*/
class RequestForecastCommand(val zipCode: String) : Command<ForecastList> {
    override fun execute(): ForecastList {
        val forecastRequest = ForecastRequest(zipCode)
        return ForecastDataMapper().convertFromDataModel(forecastRequest.execute())
    }
}