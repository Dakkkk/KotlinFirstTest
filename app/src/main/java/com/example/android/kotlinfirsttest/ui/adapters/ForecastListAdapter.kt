package com.example.android.kotlinfirsttest.adapters

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.widget.TextView
import com.example.android.kotlinfirsttest.domain.model.ForecastList

/**
 * Created by Dawid on 2017-08-05.
 */
class ForecastListAdapter(val weekForecast: ForecastList) : RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            ViewHolder {
        return ViewHolder(TextView(parent.context))
    }

    /*'with' is a function included in the standard Kotlin library. It
     basically receives an object and an extension function as parameters, and
     makes the object execute the function. This means that all the code we
     define inside the brackets acts as an extension function for the object
     provided in the first parameter, and we can use all its public functions
     and properties, as well as this. Helpful to simplify code when we
     do several operations over the same object.*/
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(weekForecast[position]) {
            holder.textView.text = "$date - $description - $high/$low"
        }
    }

    override fun getItemCount(): Int = weekForecast.dailyForecast.size

    class ViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView)
}