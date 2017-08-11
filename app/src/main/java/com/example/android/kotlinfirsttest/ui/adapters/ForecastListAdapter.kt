package com.example.android.kotlinfirsttest.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.android.kotlinfirsttest.R
import com.example.android.kotlinfirsttest.domain.model.Forecast
import com.example.android.kotlinfirsttest.domain.model.ForecastList
import com.example.android.kotlinfirsttest.ui.utils.ctx
import com.squareup.picasso.Picasso
import org.jetbrains.anko.find

/**
 * Created by Dawid on 2017-08-05.
 */

/*RecyclerView adapter*/
class ForecastListAdapter(val weekForecast: ForecastList,
                          val itemClick: ForecastListAdapter.OnItemClickListener) :
        RecyclerView.Adapter<ForecastListAdapter.ViewHolder>()  {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.ctx).inflate(R.layout.item_forecast, parent, false)
        return ViewHolder(view, itemClick)
    }

    /*'with' is a function included in the standard Kotlin library. It
     basically receives an object and an extension function as parameters, and
     makes the object execute the function. This means that all the code we
     define inside the brackets acts as an extension function for the object
     provided in the first parameter, and we can use all its public functions
     and properties, as well as this. Helpful to simplify code when we
     do several operations over the same object.*/
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindForecast(weekForecast[position])
    }

    override fun getItemCount(): Int = weekForecast.size

    class ViewHolder(view: View,
                         val itemClick: OnItemClickListener) : RecyclerView.ViewHolder(view) {
        private val iconView = view.find<ImageView>(R.id.icon)
        private val dateView = view.find<TextView>(R.id.date)
        private val descriptionView = view.find<TextView>(R.id.description)
        private val maxTemperatureView = view.find<TextView>(R.id.maxTemperature)
        private val minTemperatureView = view.find<TextView>(R.id.minTemperature)

        fun bindForecast(forecast: Forecast) {
            with(forecast) {
                Picasso.with(itemView.ctx).load(iconUrl).into(iconView)
                dateView.text = date
                descriptionView.text = description
                maxTemperatureView.text = "${high}º"
                minTemperatureView.text = "${low}º"
                itemView.setOnClickListener { itemClick(this) }
            }
        }
    }


    interface OnItemClickListener {
        operator fun invoke(forecast: Forecast)
    }
}