package be.sokarcreative.easyowm.models.hourforecast

import be.sokarcreative.easyowm.models.common.Clouds
import be.sokarcreative.easyowm.models.common.Weather
import be.sokarcreative.easyowm.models.common.Wind
import java.util.*

/**
 * Created by sokarcreative on 25/05/2017.
 * Contact : marinx.denis@gmail.com
 */
data class List(val dt : Long?,
                val main : Main?,
                val weather : Array<Weather>?,
                val clouds : Clouds?,
                val wind : Wind?,
                val sys : Sys?,
                val dt_txt : String?){
    override fun toString(): String {
        return "List(dt=$dt, main=$main, weather=${Arrays.toString(weather)}, clouds=$clouds, wind=$wind, sys=$sys, dt_txt=$dt_txt)"
    }
}