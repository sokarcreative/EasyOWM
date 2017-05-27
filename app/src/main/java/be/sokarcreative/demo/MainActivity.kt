package be.sokarcreative.demo

import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.TextView
import be.sokarcreative.easyowm.QuickWeatherUtil
import be.sokarcreative.easyowm.api.OpenWeatherMapCallback
import be.sokarcreative.easyowm.api.OpenWeatherMapManager
import be.sokarcreative.easyowm.api.WeatherIconView
import be.sokarcreative.easyowm.models.currentweather.CurrentWeatherResponse
import be.sokarcreative.easyowm.models.dailyforecast.DailyForecastResponse
import be.sokarcreative.easyowm.models.hourforecast.HourForecastResponse
import be.sokarcreative.easyowm.models.hourforecast.List
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // find views
        val textViewCurrentTmp : TextView = findViewById(R.id.textViewCurrentTemp) as TextView;
        val textViewDescription : TextView = findViewById(R.id.textViewDescription) as TextView;
        val weatherIconView : WeatherIconView = findViewById(R.id.weatherIconViewCurrent) as WeatherIconView;
        val recyclerViewHourForecast : RecyclerView = findViewById(R.id.recyclerViewHourForecast) as RecyclerView;
        val recyclerViewDailyForecast : RecyclerView = findViewById(R.id.recyclerViewDailyForecast) as RecyclerView;

        // init views
        recyclerViewHourForecast.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerViewHourForecast.adapter = HourForecastAdapter(emptyArray())
        recyclerViewDailyForecast.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerViewDailyForecast.adapter = DailyForecastAdapter(emptyArray())

        val openWeatherMapManager = OpenWeatherMapManager("82eff2c845841c89c837d4e125613d83", "fr", "metric")

        openWeatherMapManager.getCurrentWeatherByCityName("Brussel", object : OpenWeatherMapCallback<CurrentWeatherResponse>(){
            override fun success(response: CurrentWeatherResponse) {
                textViewCurrentTmp.text = getString(R.string.x_celcius,response.main?.temp?.toInt().toString())
                textViewDescription.text = response.weather?.first()?.description
                weatherIconView.setIconResource(QuickWeatherUtil.getWeatherIcon(response.weather?.first()?.id.toString(), response.weather?.first()?.icon));
                Log.i("Success", response.toString());
            }

            override fun failure(message: String) {
                Log.i("Failure", message);
            }
        })

        openWeatherMapManager.getHourForecastByCityName("Brussel", object : OpenWeatherMapCallback<HourForecastResponse>(){
            override fun success(response: HourForecastResponse) {
                Log.i("Success", response.toString());
                if(recyclerViewHourForecast.adapter is HourForecastAdapter){
                    val forecastAdapter: HourForecastAdapter = (recyclerViewHourForecast.adapter as HourForecastAdapter)
                    forecastAdapter.list = response.list as Array<List>
                    forecastAdapter.notifyDataSetChanged()
                }
            }

            override fun failure(message: String) {
                Log.i("Failure", message);
            }
        })

        openWeatherMapManager.getDailyForecastByCityName("Brussel", object : OpenWeatherMapCallback<DailyForecastResponse>(){
            override fun success(response: DailyForecastResponse) {
                Log.i("Success", response.toString());
                if(recyclerViewDailyForecast.adapter is DailyForecastAdapter){
                    val forecastAdapter: DailyForecastAdapter = (recyclerViewDailyForecast.adapter as DailyForecastAdapter)
                    forecastAdapter.list = response.list as Array<be.sokarcreative.easyowm.models.dailyforecast.List>
                    forecastAdapter.notifyDataSetChanged()
                }
            }

            override fun failure(message: String) {
                Log.i("Failure", message);
            }
        }, "16")


    }

}
