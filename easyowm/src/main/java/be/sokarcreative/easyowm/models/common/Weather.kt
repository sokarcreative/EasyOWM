package be.sokarcreative.easyowm.models.common

/**
 * Created by sokarcreative on 25/05/2017.
 * Contact : marinx.denis@gmail.com
 */
data class Weather(val id : Long?,
                   val main : String?,
                   val description : String?,
                   val icon : String?){
    override fun toString(): String {
        return "Weather(id=$id, main=$main, description=$description, icon=$icon)"
    }
}