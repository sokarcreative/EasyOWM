package be.sokarcreative.easyowm.models

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
data class Coord(val lon: Float?,
                 val lat: Float?)

data class City(val id: Long?,
                val name: String?)

data class Clouds(val all: Int?)

data class Weather(val id: Long?,
                   val main: String?,
                   val description: String?,
                   val icon: String?)

data class Wind(val speed: Double?,
                val deg: Double?)