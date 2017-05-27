# EasyOWM for Android

This library allows you to get some information about OpenWeatherMap API.<br />
The code is 100% written in kotlin -> Easier to maintain if they change their API (avoid boilerplate code).

You can get information about :
- Current weather data (by city name, city id, lat and lon or zip)
- 5 day / 3 hour forecast (by city name, city id, lat and lon or zip)
- 16 day / daily forecast (by city name, city id, lat and lon or zip + cnt)


![EasyOWM Demo Screenshot](http://sokarcreative.be/images/easyown-screenshot.png)

## Getting Started

```
// First argument is : API KEY
// "en" by default, "imperial" by default
val openWeatherMapManager = OpenWeatherMapManager("82eff2c845841c89c837d4e125613d83", "fr", "metric") 
```
#Current weather data 
```
openWeatherMapManager.getCurrentWeatherByCityName("Brussel", object : OpenWeatherMapCallback<CurrentWeatherResponse>(){
    override fun success(response: CurrentWeatherResponse) {
        Log.i("Success", response.toString());
    }

    override fun failure(message: String) {
        Log.i("Failure", message);
    }
})
```
# 5 day / 3 hour forecast
```
openWeatherMapManager.getHourForecastByCityName("Brussel", object : OpenWeatherMapCallback<HourForecastResponse>(){
    override fun success(response: HourForecastResponse) {
        Log.i("Success", response.toString());
    }

    override fun failure(message: String) {
        Log.i("Failure", message);
    }
})
```
# 16 day / daily forecast
```
openWeatherMapManager.getDailyForecastByCityName("Brussel", object : OpenWeatherMapCallback<DailyForecastResponse>(){
    override fun success(response: DailyForecastResponse) {
        Log.i("Success", response.toString());
    }

    override fun failure(message: String) {
        Log.i("Failure", message);
    }
}, "16")
```

## Motivation

Learn Kotlin

## Installation
AndroidManifest.xml

```
<uses-permission android:name="android.permission.INTERNET" />
```

Gradle !! NOT WORKING !!
 
```
 compile 'com.github.sokarcreative:easyowm:master-SNAPSHOT'
```
 Waiting for an answer from stackoverflow : https://stackoverflow.com/questions/44216121/no-way-to-compile-my-own-kotlin-library


## API Reference

OpenWeatherMap API : http://openweathermap.org/api

## Built With

* [Kotlin](https://kotlinlang.org/) - A statically-typed programming language
* [Retrofit2](http://square.github.io/retrofit/) - A type-safe HTTP client for Android and Java
* [Android Studio 3.0 Canary 2](https://developer.android.com/studio/archive.html/) - Android Studio Preview Version

## License

Copyright 2017 Denis Marinx

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
