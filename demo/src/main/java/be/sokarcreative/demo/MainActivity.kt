package be.sokarcreative.demo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.CompoundButton
import android.widget.Toast
import be.sokarcreative.easyowm.api.OpenWeatherMap
import be.sokarcreative.easyowm.api.OpenWeatherMapCallback
import be.sokarcreative.easyowm.models.currentweather.CurrentWeatherResponse
import be.sokarcreative.easyowm.models.dailyforecast.DailyForecastResponse
import be.sokarcreative.easyowm.models.hourforecast.HourForecastResponse
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject lateinit var openWeatherMapApi: OpenWeatherMap

    lateinit var request: Request
    lateinit var arg: Arg

    enum class Request(val code: Int){
        WEATHER(1),
        DAILY_FORECAST(10),
        HOUR_FORECAST(100)
    }

    enum class Arg(val code: Int){
        BY_CITY_NAME(1),
        BY_CITY_ID(2),
        BY_LAT_LNG(3),
        BY_ZIP(4)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        (application as MyApplication).component.inject(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        radioByCityName.setOnCheckedChangeListener({ _: CompoundButton, checked: Boolean ->
            if(checked) {
                arg = Arg.BY_CITY_NAME
                textViewLabel.text = "City Name : "
                editTextValue.setText(cityName)
            }
        })
        radioByCityId.setOnCheckedChangeListener({ _: CompoundButton, checked: Boolean ->
            if(checked) {
                arg = Arg.BY_CITY_ID
                textViewLabel.text = "City Id : "
                editTextValue.setText(cityId)
            }
        })
        radioByLatLng.setOnCheckedChangeListener({ _: CompoundButton, checked: Boolean ->
            if(checked) {
                arg = Arg.BY_LAT_LNG
                textViewLabel.text = "Lat Lng (lat-lng) : "
                editTextValue.setText(lat+"-"+lon)
            }
        })

        radioByZip.setOnCheckedChangeListener({ _: CompoundButton, checked: Boolean ->
            if(checked){
                arg = Arg.BY_ZIP
                textViewLabel.text = "Zip : "
                editTextValue.setText(zip)
            }
        })

        radioWeather.setOnCheckedChangeListener({ _: CompoundButton, checked: Boolean ->
            if(checked){
                request = Request.WEATHER
            }
        })
        radioDayForecast.setOnCheckedChangeListener({ _: CompoundButton, checked: Boolean ->
            if(checked){
                request = Request.DAILY_FORECAST
            }
        })
        radioHourForecast.setOnCheckedChangeListener({ _: CompoundButton, checked: Boolean ->
            if(checked){
                request = Request.HOUR_FORECAST
            }
        })

        radioWeather.isChecked = true
        radioByCityName.isChecked = true

        buttonExecute.setOnClickListener({
            editTextValue.text.toString().takeIf { it.isNotBlank() }?.let {
                if(arg != Arg.BY_LAT_LNG || it.split("-").size == 2){
                    when(request.code + arg.code){
                        Request.WEATHER.code + Arg.BY_CITY_NAME.code -> openWeatherMapApi.getCurrentWeatherByCityName(it, logResponse<CurrentWeatherResponse>())
                        Request.WEATHER.code + Arg.BY_CITY_ID.code -> openWeatherMapApi.getCurrentWeatherByCityId(it, logResponse<CurrentWeatherResponse>())
                        Request.WEATHER.code + Arg.BY_LAT_LNG.code -> {
                            val values = it.split("-")
                            openWeatherMapApi.getCurrentWeatherByGeographicCoordinates(values[0], values[1], logResponse<CurrentWeatherResponse>())
                        }
                        Request.WEATHER.code + Arg.BY_ZIP.code -> openWeatherMapApi.getCurrentWeatherByZip(it, logResponse<CurrentWeatherResponse>())

                        Request.DAILY_FORECAST.code + Arg.BY_CITY_NAME.code -> openWeatherMapApi.getDailyForecastByCityName(it, logResponse<DailyForecastResponse>())
                        Request.DAILY_FORECAST.code + Arg.BY_CITY_ID.code -> openWeatherMapApi.getDailyForecastByCityId(it, logResponse<DailyForecastResponse>())
                        Request.DAILY_FORECAST.code + Arg.BY_LAT_LNG.code -> {
                            val values = it.split("-")
                            openWeatherMapApi.getDailyForecastByGeographicCoordinates(values[0], values[1], logResponse<DailyForecastResponse>())
                        }
                        Request.DAILY_FORECAST.code + Arg.BY_ZIP.code -> openWeatherMapApi.getDailyForecastByZip(it, logResponse<DailyForecastResponse>())

                        Request.HOUR_FORECAST.code + Arg.BY_CITY_NAME.code -> openWeatherMapApi.getHourForecastByCityName(it, logResponse<HourForecastResponse>())
                        Request.HOUR_FORECAST.code + Arg.BY_CITY_ID.code -> openWeatherMapApi.getHourForecastByCityId(it, logResponse<HourForecastResponse>())
                        Request.HOUR_FORECAST.code + Arg.BY_LAT_LNG.code -> {
                            val values = it.split("-")
                            openWeatherMapApi.getHourForecastByGeographicCoordinates(values[0], values[1], logResponse<HourForecastResponse>())
                        }
                        Request.HOUR_FORECAST.code + Arg.BY_ZIP.code -> openWeatherMapApi.getHourForecastByZip(it, logResponse<HourForecastResponse>())
                    }
                }else {
                    Toast.makeText(this, "lat and lng should be separated by a '-'", Toast.LENGTH_LONG).show()
                }
            }?:let {
                Toast.makeText(this, "Value cannot be empty", Toast.LENGTH_SHORT).show()
            }
        })
    }


    private fun <S> logResponse() : OpenWeatherMapCallback<S> = object : OpenWeatherMapCallback<S>() {
        override fun onSuccess(response: S) {
            Log.i("Success", response.toString())
            textViewResponse.text = response.toString()
        }

        override fun onFailure(message: String) {
            Log.i("Failure", message)
            textViewResponse.text = message
        }
    }


    companion object {
        const val cityName = "London"
        const val cityId = "524901"
        const val zip = "94040"
        const val lon = "5.9442"
        const val lat = "50.2965"
    }



}
