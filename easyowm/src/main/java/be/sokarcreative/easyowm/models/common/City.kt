package be.sokarcreative.easyowm.models.common

/**
 * Created by sokarcreative on 25/05/2017.
 * Contact : marinx.denis@gmail.com
 */
data class City(val id : Long?, val name : String?){
    override fun toString(): String {
        return "City(id=$id, name=$name)"
    }
}