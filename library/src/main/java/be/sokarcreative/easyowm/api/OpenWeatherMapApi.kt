package be.sokarcreative.easyowm.api

import be.sokarcreative.easyowm.models.currentweather.CurrentWeatherResponse
import be.sokarcreative.easyowm.models.dailyforecast.DailyForecastResponse
import be.sokarcreative.easyowm.models.hourforecast.HourForecastResponse

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
interface OpenWeatherMapApi{

    // Current Weather
    @retrofit2.http.GET("weather")
    fun getCurrentWeatherByCityName(@retrofit2.http.Query("appid") appId: String,
                                    @retrofit2.http.Query("q") cityName: String,
                                    @retrofit2.http.Query("lang") lang: String,
                                    @retrofit2.http.Query("units") units: String): retrofit2.Call<CurrentWeatherResponse>
    @retrofit2.http.GET("weather")
    fun getCurrentWeatherByCityId(@retrofit2.http.Query("appid") appId: String,
                                  @retrofit2.http.Query("id") cityId: String,
                                  @retrofit2.http.Query("lang") lang: String,
                                  @retrofit2.http.Query("units") units: String): retrofit2.Call<CurrentWeatherResponse>
    @retrofit2.http.GET("weather")
    fun getCurrentWeatherByGeographicCoordinates(@retrofit2.http.Query("appid") appId: String,
                                                 @retrofit2.http.Query("lat") lat: String,
                                                 @retrofit2.http.Query("lon") lon: String,
                                                 @retrofit2.http.Query("lang") lang: String,
                                                 @retrofit2.http.Query("units") units: String): retrofit2.Call<CurrentWeatherResponse>
    @retrofit2.http.GET("weather")
    fun getCurrentWeatherByZip(@retrofit2.http.Query("appid") appId: String,
                               @retrofit2.http.Query("zip") zip: String,
                               @retrofit2.http.Query("lang") lang: String,
                               @retrofit2.http.Query("units") units: String): retrofit2.Call<CurrentWeatherResponse>

    // Call 5 day / 3 hour forecast data
    @retrofit2.http.GET("forecast")
    fun getHourForecastByCityName(@retrofit2.http.Query("appid") appId: String,
                                  @retrofit2.http.Query("q") cityName: String,
                                  @retrofit2.http.Query("lang") lang: String,
                                  @retrofit2.http.Query("units") units: String): retrofit2.Call<HourForecastResponse>
    @retrofit2.http.GET("forecast")
    fun getHourForecastByCityId(@retrofit2.http.Query("appid") appId: String,
                                @retrofit2.http.Query("id") cityId: String,
                                @retrofit2.http.Query("lang") lang: String,
                                @retrofit2.http.Query("units") units: String): retrofit2.Call<HourForecastResponse>
    @retrofit2.http.GET("forecast")
    fun getHourForecastByGeographicCoordinates(@retrofit2.http.Query("appid") appId: String,
                                               @retrofit2.http.Query("lat") lat: String,
                                               @retrofit2.http.Query("lon") lon: String,
                                               @retrofit2.http.Query("lang") lang: String,
                                               @retrofit2.http.Query("units") units: String): retrofit2.Call<HourForecastResponse>
    @retrofit2.http.GET("forecast")
    fun getHourForecastByZip(@retrofit2.http.Query("appid") appId: String,
                             @retrofit2.http.Query("zip") zip: String,
                             @retrofit2.http.Query("lang") lang: String,
                             @retrofit2.http.Query("units") units: String): retrofit2.Call<HourForecastResponse>

    // Call 16 day / daily forecast data
    @retrofit2.http.GET("forecast/daily")
    fun getDailyForecastByCityName(@retrofit2.http.Query("appid") appId: String,
                                   @retrofit2.http.Query("q") cityName: String,
                                   @retrofit2.http.Query("cnt") cnt: String,
                                   @retrofit2.http.Query("lang") lang: String,
                                   @retrofit2.http.Query("units") units: String): retrofit2.Call<DailyForecastResponse>
    @retrofit2.http.GET("forecast/daily")
    fun getDailyForecastByCityId(@retrofit2.http.Query("appid") appId: String,
                                 @retrofit2.http.Query("id") cityId: String,
                                 @retrofit2.http.Query("cnt") cnt: String,
                                 @retrofit2.http.Query("lang") lang: String,
                                 @retrofit2.http.Query("units") units: String): retrofit2.Call<DailyForecastResponse>
    @retrofit2.http.GET("forecast/daily")
    fun getDailyForecastByGeographicCoordinates(@retrofit2.http.Query("appid") appId: String,
                                                @retrofit2.http.Query("lat") lat: String,
                                                @retrofit2.http.Query("lon") lon: String,
                                                @retrofit2.http.Query("cnt") cnt: String,
                                                @retrofit2.http.Query("lang") lang: String,
                                                @retrofit2.http.Query("units") units: String): retrofit2.Call<DailyForecastResponse>
    @retrofit2.http.GET("forecast/daily")
    fun getDailyForecastByZip(@retrofit2.http.Query("appid") appId: String,
                              @retrofit2.http.Query("zip") zip: String,
                              @retrofit2.http.Query("cnt") cnt: String,
                              @retrofit2.http.Query("lang") lang: String,
                              @retrofit2.http.Query("units") units: String): retrofit2.Call<DailyForecastResponse>
}