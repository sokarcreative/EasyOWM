package be.sokarcreative.easyowm.models.common

/**
 * Created by sokarcreative on 25/05/2017.
 * Contact : marinx.denis@gmail.com
 */
data class Wind(val speed : Double?,
                val deg : Double?){
    override fun toString(): String {
        return "Wind(speed=$speed, deg=$deg)"
    }
}
