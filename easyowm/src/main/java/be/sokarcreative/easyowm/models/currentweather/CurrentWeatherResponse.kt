package be.sokarcreative.easyowm.models.currentweather

import be.sokarcreative.easyowm.models.common.Clouds
import be.sokarcreative.easyowm.models.common.Coord
import be.sokarcreative.easyowm.models.common.Weather
import be.sokarcreative.easyowm.models.common.Wind
import java.util.*

/**
 * Created by sokarcreative on 25/05/2017.
 * Contact : marinx.denis@gmail.com
 */
class CurrentWeatherResponse(val coord: Coord?,
                             val weather : Array<Weather>?,
                             val base : String?,
                             val main : Main?,
                             val visibility : Long?,
                             val wind : Wind?,
                             val clouds : Clouds?,
                             val dt : Long?,
                             val sys : Sys?,
                             val id : Long?,
                             val name : String?,
                             val cod : String?) {
    override fun toString(): String {
        return "CurrentWeatherResponse(coord=$coord, weather=${Arrays.toString(weather)}, base=$base, main=$main, visibility=$visibility, wind=$wind, clouds=$clouds, dt=$dt, sys=$sys, id=$id, name=$name, cod=$cod)"
    }
}
