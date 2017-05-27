package be.sokarcreative.easyowm.api

import be.sokarcreative.easyowm.models.currentweather.CurrentWeatherResponse
import be.sokarcreative.easyowm.models.dailyforecast.DailyForecastResponse
import be.sokarcreative.easyowm.models.hourforecast.HourForecastResponse


/**
 * Created by sokarcreative on 25/05/2017.
 * Contact : marinx.denis@gmail.com
 */
class OpenWeatherMapManager(val apiKey: String, val lang : String = "en", val units : String = "imperial") {
    private var api: RestApi = RestApi.Companion.instance

    // Current Weather
    fun getCurrentWeatherByCityName(cityName: String, openWeatherMapCallback: OpenWeatherMapCallback<CurrentWeatherResponse>) = enqueue(openWeatherMapCallback, api.openWeatherMapApi.getCurrentWeatherByCityName(apiKey, cityName, lang, units))
    fun getCurrentWeatherByCityId(cityId: String, openWeatherMapCallback: OpenWeatherMapCallback<CurrentWeatherResponse>) = enqueue(openWeatherMapCallback, api.openWeatherMapApi.getCurrentWeatherByCityId(apiKey, cityId, lang, units))
    fun getCurrentWeatherByGeographicCoordinates(lat: String, lon:String, openWeatherMapCallback: OpenWeatherMapCallback<CurrentWeatherResponse>) = enqueue(openWeatherMapCallback, api.openWeatherMapApi.getCurrentWeatherByGeographicCoordinates(apiKey, lat, lon, lang, units))
    fun getCurrentWeatherByZip(zip: String, openWeatherMapCallback: OpenWeatherMapCallback<CurrentWeatherResponse>) = enqueue(openWeatherMapCallback, api.openWeatherMapApi.getCurrentWeatherByZip(apiKey, zip, lang, units))

    // Call 5 day / 3 hour forecast data
    fun getHourForecastByCityName(cityName: String, openWeatherMapCallback: OpenWeatherMapCallback<HourForecastResponse>) = enqueue(openWeatherMapCallback, api.openWeatherMapApi.getHourForecastByCityName(apiKey, cityName, lang, units))
    fun getHourForecastByCityId(cityId: String, openWeatherMapCallback: OpenWeatherMapCallback<HourForecastResponse>) = enqueue(openWeatherMapCallback, api.openWeatherMapApi.getHourForecastByCityId(apiKey, cityId, lang, units))
    fun getHourForecastByGeographicCoordinates(lat: String, lon:String, openWeatherMapCallback: OpenWeatherMapCallback<HourForecastResponse>) = enqueue(openWeatherMapCallback, api.openWeatherMapApi.getHourForecastByGeographicCoordinates(apiKey, lat, lon, lang, units))
    fun getHourForecastByZip(zip: String, openWeatherMapCallback: OpenWeatherMapCallback<HourForecastResponse>) = enqueue(openWeatherMapCallback, api.openWeatherMapApi.getHourForecastByZip(apiKey, zip, lang, units))

    // Call 16 day / daily forecast data
    fun getDailyForecastByCityName(cityName: String, openWeatherMapCallback: OpenWeatherMapCallback<DailyForecastResponse>, cnt : String = "7") = enqueue(openWeatherMapCallback, api.openWeatherMapApi.getDailyForecastByCityName(apiKey, cityName, cnt, lang, units))
    fun getDailyForecastByCityId(cityId: String, openWeatherMapCallback: OpenWeatherMapCallback<DailyForecastResponse>, cnt : String = "7") = enqueue(openWeatherMapCallback, api.openWeatherMapApi.getDailyForecastByCityId(apiKey, cityId, cnt, lang, units))
    fun getDailyForecastByGeographicCoordinates(lat: String, lon:String, openWeatherMapCallback: OpenWeatherMapCallback<DailyForecastResponse>, cnt : String = "7") = enqueue(openWeatherMapCallback, api.openWeatherMapApi.getDailyForecastByGeographicCoordinates(apiKey, lat, lon, cnt, lang, units))
    fun getDailyForecastByZip(zip: String, openWeatherMapCallback: OpenWeatherMapCallback<DailyForecastResponse>, cnt : String = "7") = enqueue(openWeatherMapCallback, api.openWeatherMapApi.getDailyForecastByZip(apiKey, zip, cnt, lang, units))


    private fun <T> enqueue(mapCallback: OpenWeatherMapCallback<T>, objCall: retrofit2.Call<T>) {
        objCall.enqueue(object :  RetrofitCallback<T>() {

            override fun onResponseWeatherResponse(call: retrofit2.Call<T>, response: retrofit2.Response<T>) {
                if (!response.isSuccessful)
                    mapCallback.failure("Failed")
            }

            override fun onResponseWeatherObject(call: retrofit2.Call<T>, response: T) {
                mapCallback.success(response)
            }
        })
    }


}