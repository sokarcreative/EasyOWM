package be.sokarcreative.easyowm.models.dailyforecast

import be.sokarcreative.easyowm.models.common.City
import be.sokarcreative.easyowm.models.common.Coord
import java.util.*

/**
 * Created by sokarcreative on 26/05/2017.
 * Contact : marinx.denis@gmail.com
 */
data class DailyForecastResponse(val cod : String?,
                                 val message : Double?,
                                 val city : City?,
                                 val coord : Coord?,
                                 val country : String?,
                                 val cnt : Int?,
                                 val list : Array<List>?){
    override fun toString(): String {
        return "DailyForecastResponse(cod=$cod, message=$message, city=$city, coord=$coord, country=$country, cnt=$cnt, list=${Arrays.toString(list)})"
    }
}