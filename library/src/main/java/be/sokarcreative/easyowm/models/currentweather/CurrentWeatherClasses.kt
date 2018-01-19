package be.sokarcreative.easyowm.models.currentweather

import be.sokarcreative.easyowm.models.Clouds
import be.sokarcreative.easyowm.models.Coord
import be.sokarcreative.easyowm.models.Weather
import be.sokarcreative.easyowm.models.Wind

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
data class CurrentWeatherResponse(val coord: Coord?,
                                  val weather : Array<Weather>?,
                                  val base : String?,
                                  val main : Main?,
                                  val visibility : Long?,
                                  val wind : Wind?,
                                  val clouds : Clouds?,
                                  val dt : Long?,
                                  val sys : Sys?,
                                  val id : Long?,
                                  val name : String?,
                                  val cod : String?)

data class Main(val temp : Float?,
                val pressure : Float?,
                val humidity : Float?,
                val temp_min : Float?,
                val temp_max : Float?)

data class Sys(val type : Int?,
               val id : Long?,
               val message : Double?,
               val country : String?,
               val sunrise : Long?,
               val sunset : Long?)