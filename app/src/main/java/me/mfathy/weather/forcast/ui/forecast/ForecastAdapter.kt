package me.mfathy.weather.forcast.ui.forecast

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import me.mfathy.weather.forcast.R
import me.mfathy.weather.forcast.domain.model.DailyForecast
import javax.inject.Inject

/**
 * Created by Mohammed Fathy on 17/12/2018.
 * dev.mfathy@gmail.com
 *
 * Airports recycler view adapter
 */
class ForecastAdapter @Inject constructor() : RecyclerView.Adapter<ForecastAdapter.ViewHolder>() {

    public var mForecasts: List<DailyForecast> = listOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ForecastAdapter.ViewHolder {
        val itemView = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.view_item_forecast, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return mForecasts.count()
    }

    override fun onBindViewHolder(holder: ForecastAdapter.ViewHolder, position: Int) {
        val forecast = mForecasts[position]
        holder.textViewDay?.text = forecast.dayText
        holder.textViewTemp?.text = "${forecast.temperature.maximum.value} / ${forecast.temperature.minimum.value} ${forecast.temperature.maximum.unit}"
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var textViewDay: TextView? = view.findViewById(R.id.textViewDay)
        var textViewTemp: TextView? = view.findViewById(R.id.textViewTemp)
    }
}