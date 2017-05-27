package be.sokarcreative.easyowm.models.currentweather

/**
 * Created by sokarcreative on 25/05/2017.
 * Contact : marinx.denis@gmail.com
 */
data class Sys(val type : Int?,
               val id : Long?,
               val message : Double?,
               val country : String?,
               val sunrise : Long?,
               val sunset : Long?){
    override fun toString(): String {
        return "Sys(type=$type, id=$id, message=$message, country=$country, sunrise=$sunrise, sunset=$sunset)"
    }
}