package be.sokarcreative.easyowm.api

import be.sokarcreative.easyowm.models.currentweather.CurrentWeatherResponse
import be.sokarcreative.easyowm.models.dailyforecast.DailyForecastResponse
import be.sokarcreative.easyowm.models.hourforecast.HourForecastResponse
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


/**
 * Copyright (C) 2017 sokarcreative
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
class OpenWeatherMap(var okHttpClient: OkHttpClient, var apiKey: String, var lang : String = "en", var units : String = "imperial"){

    private val openWeatherMapApi: OpenWeatherMapApi by lazy {
        Retrofit.Builder()
                .baseUrl("http://api.openweathermap.org/data/2.5/")
                .addConverterFactory(MoshiConverterFactory.create())
                .client(okHttpClient)
                .build().create(OpenWeatherMapApi::class.java)
    }

    // Current Weather
    fun getCurrentWeatherByCityName(cityName: String, openWeatherMapCallback: OpenWeatherMapCallback<CurrentWeatherResponse>) = enqueue(openWeatherMapCallback, openWeatherMapApi.getCurrentWeatherByCityName(apiKey, cityName,lang, units))
    fun getCurrentWeatherByCityId(cityId: String, openWeatherMapCallback: OpenWeatherMapCallback<CurrentWeatherResponse>) = enqueue(openWeatherMapCallback, openWeatherMapApi.getCurrentWeatherByCityId(apiKey, cityId, lang, units))
    fun getCurrentWeatherByGeographicCoordinates(lat: String, lon:String, openWeatherMapCallback: OpenWeatherMapCallback<CurrentWeatherResponse>) = enqueue(openWeatherMapCallback, openWeatherMapApi.getCurrentWeatherByGeographicCoordinates(apiKey, lat, lon, lang, units))
    fun getCurrentWeatherByZip(zip: String, openWeatherMapCallback: OpenWeatherMapCallback<CurrentWeatherResponse>) = enqueue(openWeatherMapCallback, openWeatherMapApi.getCurrentWeatherByZip(apiKey, zip, lang, units))

    // Call 5 day / 3 hour forecast data
    fun getHourForecastByCityName(cityName: String, openWeatherMapCallback: OpenWeatherMapCallback<HourForecastResponse>) = enqueue(openWeatherMapCallback, openWeatherMapApi.getHourForecastByCityName(apiKey, cityName, lang, units))
    fun getHourForecastByCityId(cityId: String, openWeatherMapCallback: OpenWeatherMapCallback<HourForecastResponse>) = enqueue(openWeatherMapCallback, openWeatherMapApi.getHourForecastByCityId(apiKey, cityId, lang, units))
    fun getHourForecastByGeographicCoordinates(lat: String, lon:String, openWeatherMapCallback: OpenWeatherMapCallback<HourForecastResponse>) = enqueue(openWeatherMapCallback, openWeatherMapApi.getHourForecastByGeographicCoordinates(apiKey, lat, lon, lang, units))
    fun getHourForecastByZip(zip: String, openWeatherMapCallback: OpenWeatherMapCallback<HourForecastResponse>) = enqueue(openWeatherMapCallback, openWeatherMapApi.getHourForecastByZip(apiKey, zip, lang, units))

    // Call 16 day / daily forecast data
    fun getDailyForecastByCityName(cityName: String, openWeatherMapCallback: OpenWeatherMapCallback<DailyForecastResponse>, cnt : String = "7") = enqueue(openWeatherMapCallback, openWeatherMapApi.getDailyForecastByCityName(apiKey, cityName, cnt, lang, units))
    fun getDailyForecastByCityId(cityId: String, openWeatherMapCallback: OpenWeatherMapCallback<DailyForecastResponse>, cnt : String = "7") = enqueue(openWeatherMapCallback, openWeatherMapApi.getDailyForecastByCityId(apiKey, cityId, cnt, lang, units))
    fun getDailyForecastByGeographicCoordinates(lat: String, lon:String, openWeatherMapCallback: OpenWeatherMapCallback<DailyForecastResponse>, cnt : String = "7") = enqueue(openWeatherMapCallback, openWeatherMapApi.getDailyForecastByGeographicCoordinates(apiKey, lat, lon, cnt, lang, units))
    fun getDailyForecastByZip(zip: String, openWeatherMapCallback: OpenWeatherMapCallback<DailyForecastResponse>, cnt : String = "7") = enqueue(openWeatherMapCallback, openWeatherMapApi.getDailyForecastByZip(apiKey, zip, cnt, lang, units))


    private fun <T> enqueue(mapCallback: OpenWeatherMapCallback<T>, objCall: retrofit2.Call<T>) {
        objCall.enqueue(object :  RetrofitCallback<T>() {

            override fun onResponseWeatherResponse(call: retrofit2.Call<T>, response: retrofit2.Response<T>) {
                if (!response.isSuccessful)
                    mapCallback.onFailure("Failed")
            }

            override fun onResponseWeatherObject(call: retrofit2.Call<T>, response: T) {
                mapCallback.onSuccess(response)
            }
        })
    }

}


