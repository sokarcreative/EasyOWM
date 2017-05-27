package be.sokarcreative.demo

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.ViewHolder
import android.view.ViewGroup
import be.sokarcreative.easyowm.models.hourforecast.List
import android.view.LayoutInflater
import be.sokarcreative.easyowm.QuickWeatherUtil
import be.sokarcreative.demo.databinding.HolderForecastBinding
import java.text.SimpleDateFormat
import java.util.*


/**
 * Created by sokarcreative on 26/05/2017.
 * Contact : marinx.denis@gmail.com
 */
class HourForecastAdapter(var list : Array<List>) : RecyclerView.Adapter<HourForecastAdapter.ViewHolderHourForecast>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolderHourForecast {
        return ViewHolderHourForecast(DataBindingUtil.bind(LayoutInflater.from(parent?.context).inflate(R.layout.holder_forecast, parent, false)))
    }

    override fun onBindViewHolder(viewHolderHourForecast: ViewHolderHourForecast?, position: Int) {
        viewHolderHourForecast?.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }


    class ViewHolderHourForecast(val viewDataBinding: HolderForecastBinding) : ViewHolder(viewDataBinding.root) {

        fun bind(list : List){
            viewDataBinding.textViewDescription.text = list.weather?.first()?.description
            viewDataBinding.textViewInfo.text = convertDate(list.dt_txt.toString())
            viewDataBinding.textViewTmp.text = viewDataBinding.root.context.getString(R.string.x_celcius, list.main?.temp?.toInt().toString())
            viewDataBinding.weatherIconView.setIconResource(QuickWeatherUtil.getWeatherIcon(list.weather?.first()?.id.toString(), list.weather?.first()?.icon))
        }

        companion object {
            private val sdfOut = SimpleDateFormat("EEE HH'h'mm", Locale.getDefault())
            private val sdfIn = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
        }

        fun convertDate(dateString: String): String = sdfOut.format(sdfIn.parse(dateString)).capitalize()

    }

}