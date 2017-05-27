package be.sokarcreative.easyowm.models.dailyforecast

import be.sokarcreative.easyowm.models.common.Weather
import java.util.*

/**
 * Created by sokarcreative on 25/05/2017.
 * Contact : marinx.denis@gmail.com
 */
data class List(val dt : Long?,
                val temp : Temp?,
                val pressure : Double?,
                val humidity : Double?,
                val weather : Array<Weather>?){
    override fun toString(): String {
        return "List(dt=$dt, temp=$temp, pressure=$pressure, humidity=$humidity, weather=${Arrays.toString(weather)})"
    }
}