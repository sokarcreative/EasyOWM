package be.sokarcreative.demo

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.ViewHolder
import android.view.ViewGroup
import android.view.LayoutInflater
import be.sokarcreative.easyowm.QuickWeatherUtil
import be.sokarcreative.easyowm.models.dailyforecast.List
import be.sokarcreative.demo.databinding.HolderForecastBinding
import java.text.SimpleDateFormat
import java.util.*


/**
 * Created by sokarcreative on 26/05/2017.
 * Contact : marinx.denis@gmail.com
 */
class DailyForecastAdapter(var list : Array<be.sokarcreative.easyowm.models.dailyforecast.List>) : RecyclerView.Adapter<DailyForecastAdapter.ViewHolderDailyForecast>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolderDailyForecast {
        return ViewHolderDailyForecast(DataBindingUtil.bind(LayoutInflater.from(parent?.context).inflate(R.layout.holder_forecast, parent, false)))
    }

    override fun onBindViewHolder(viewHolderHourForecast: ViewHolderDailyForecast?, position: Int) {
        viewHolderHourForecast?.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }


    class ViewHolderDailyForecast(val viewDataBinding: HolderForecastBinding) : ViewHolder(viewDataBinding.root) {
        fun bind(list : List){
            viewDataBinding.textViewDescription.text = list.weather?.first()?.description
            viewDataBinding.textViewInfo.text = convertDate(list.dt as Long)
            viewDataBinding.textViewTmp.text = viewDataBinding.root.context.getString(R.string.x_celcius, list.temp?.day?.toInt().toString())
            viewDataBinding.weatherIconView.setIconResource(QuickWeatherUtil.getWeatherIcon(list.weather?.first()?.id.toString(), list.weather?.first()?.icon))
        }

        companion object {
            private val sdfOut = SimpleDateFormat("EEE dd/MM", Locale.getDefault())
        }

        fun convertDate(dt: Long): String = sdfOut.format(dt*1000).capitalize()

    }

}