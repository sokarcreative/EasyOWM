package be.sokarcreative.easyowm.models.dailyforecast

/**
 * Created by sokarcreative on 25/05/2017.
 * Contact : marinx.denis@gmail.com
 */
data class Temp(val day : Double?,
                val min : Double?,
                val max : Double?,
                val night : Double?,
                val eve : Double?,
                val morn : Double?){
    override fun toString(): String {
        return "Temp(day=$day, min=$min, max=$max, night=$night, eve=$eve, morn=$morn)"
    }
}