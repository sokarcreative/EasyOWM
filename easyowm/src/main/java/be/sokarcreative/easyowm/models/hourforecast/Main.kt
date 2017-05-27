package be.sokarcreative.easyowm.models.hourforecast

/**
 * Created by sokarcreative on 25/05/2017.
 * Contact : marinx.denis@gmail.com
 */
data class Main(val temp : Double?,
                val pressure : Double?,
                val humidity : Double?,
                val temp_min : Double?,
                val temp_max : Double?,
                val sea_level : Double?,
                val grnd_level : Double?,
                val temp_kf : Double?){
    override fun toString(): String {
        return "Main(temp=$temp, pressure=$pressure, humidity=$humidity, temp_min=$temp_min, temp_max=$temp_max, sea_level=$sea_level, grnd_level=$grnd_level, temp_kf=$temp_kf)"
    }
}