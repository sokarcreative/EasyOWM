# EasyOWM

This library allows you to get safe and easy information from the OpenWeatherMap API
100% in kotlin (null safe / no more boilerplate code) -> Easy to maintain if they change their API.

You can get information about :
- Current weather data (by city name, city id, lat and lon or zip)
- 5 day / 3 hour forecast (by city name, city id, lat and lon or zip)
- 16 day / daily forecast (by city name, city id, lat and lon or zip + cnt)

## Getting Started

Code is coming

## Motivation

Learn Kotlin

## Installation
-- AndroidManifest.xml

```
<uses-permission android:name="android.permission.INTERNET" />

```

-- gradle
 !! NOT WORKING FOR !! 
 
```
 compile 'com.github.sokarcreative:easyowm:master-SNAPSHOT'
 
```
 Waiting answer from stackoverflow : https://stackoverflow.com/questions/44216121/no-way-to-compile-my-own-kotlin-library


## API Reference

OpenWeatherMap API : http://openweathermap.org/api

## Built With

* [Kotlin](https://kotlinlang.org/) - A statically-typed programming language
* [Retrofit](http://square.github.io/retrofit/) - A type-safe HTTP client for Android and Java
* [Android Studio 3.0 Canary 2](https://developer.android.com/studio/archive.html/) - Android Studio Preview Version

## License

Copyright [2017] [Denis Marinx]

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
