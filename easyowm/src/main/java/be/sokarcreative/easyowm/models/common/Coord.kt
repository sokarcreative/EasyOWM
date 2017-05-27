package be.sokarcreative.easyowm.models.common

/**
 * Created by sokarcreative on 25/05/2017.
 * Contact : marinx.denis@gmail.com
 */
data class Coord(val lon: Float?,
                 val lat : Float?){
    override fun toString(): String {
        return "Coord(lon=$lon, lat=$lat)"
    }
}
