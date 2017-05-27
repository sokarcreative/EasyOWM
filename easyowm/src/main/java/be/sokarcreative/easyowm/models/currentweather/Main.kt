package be.sokarcreative.easyowm.models.currentweather

/**
 * Created by sokarcreative on 25/05/2017.
 * Contact : marinx.denis@gmail.com
 */
data class Main(val temp : Float?,
                val pressure : Float?,
                val humidity : Float?,
                val temp_min : Float?,
                val temp_max : Float?){
    override fun toString(): String {
        return "Main(temp=$temp, pressure=$pressure, humidity=$humidity, temp_min=$temp_min, temp_max=$temp_max)"
    }
}