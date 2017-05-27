package be.sokarcreative.easyowm.models.hourforecast

/**
 * Created by sokarcreative on 25/05/2017.
 * Contact : marinx.denis@gmail.com
 */
data class Sys(val pod : String?){
    override fun toString(): String {
        return "Sys(pod='$pod')"
    }
}