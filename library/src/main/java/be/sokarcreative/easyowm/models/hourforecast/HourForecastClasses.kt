package be.sokarcreative.easyowm.models.hourforecast

import be.sokarcreative.easyowm.models.*

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
data class HourForecastResponse(val city : City?,
                           val coord: Coord?,
                           val country : String?,
                           val cod : String?,
                           val message : Double?,
                           val cnt : Int?,
                           val list : Array<List>?)

data class List(val dt : Long?,
                val main : Main?,
                val weather : Array<Weather>?,
                val clouds : Clouds?,
                val wind : Wind?,
                val sys : Sys?,
                val dt_txt : String?)

data class Main(val temp : Double?,
                val pressure : Double?,
                val humidity : Double?,
                val temp_min : Double?,
                val temp_max : Double?,
                val sea_level : Double?,
                val grnd_level : Double?,
                val temp_kf : Double?)

data class Sys(val pod : String?)