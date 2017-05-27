package be.sokarcreative.easyowm.api

/**
 * Created by sokarcreative on 25/05/2017.
 * Contact : marinx.denis@gmail.com
 */
abstract class OpenWeatherMapCallback<S>() {

    abstract fun success(response: S)

    abstract fun failure(message: String)
}
