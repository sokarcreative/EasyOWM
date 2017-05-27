package be.sokarcreative.easyowm.models.hourforecast

import be.sokarcreative.easyowm.models.common.City
import be.sokarcreative.easyowm.models.common.Coord
import java.util.*

/**
 * Created by sokarcreative on 25/05/2017.
 * Contact : marinx.denis@gmail.com
 */
class HourForecastResponse(val city : City?,
                           val coord: Coord?,
                           val country : String?,
                           val cod : String?,
                           val message : Double?,
                           val cnt : Int?,
                           val list : Array<List>?){
    override fun toString(): String {
        return "HourForecastResponse(city=$city, coord=$coord, country=$country, cod=$cod, message=$message, cnt=$cnt, list=${Arrays.toString(list)})"
    }
}
