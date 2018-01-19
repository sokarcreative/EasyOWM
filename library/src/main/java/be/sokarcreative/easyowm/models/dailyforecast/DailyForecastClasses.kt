package be.sokarcreative.easyowm.models.dailyforecast

import be.sokarcreative.easyowm.models.City
import be.sokarcreative.easyowm.models.Coord
import be.sokarcreative.easyowm.models.Weather

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
data class DailyForecastResponse(val cod : String?,
                                 val message : Double?,
                                 val city : City?,
                                 val coord : Coord?,
                                 val country : String?,
                                 val cnt : Int?,
                                 val list : Array<List>?)

data class List(val dt : Long?,
                val temp : Temp?,
                val pressure : Double?,
                val humidity : Double?,
                val weather : Array<Weather>?)

data class Temp(val day : Double?,
                val min : Double?,
                val max : Double?,
                val night : Double?,
                val eve : Double?,
                val morn : Double?)