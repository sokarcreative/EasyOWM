package be.sokarcreative.easyowm.api


/**
 * Created by sokarcreative on 25/05/2017.
 * Contact : marinx.denis@gmail.com
 */
abstract class RetrofitCallback<S> : retrofit2.Callback<S> {
    override fun onFailure(call: retrofit2.Call<S>, t: Throwable) {
        android.util.Log.e("Error", "It looks like OWM API has important changes..")
    }
    override fun onResponse(call: retrofit2.Call<S>, response: retrofit2.Response<S>) {
        onResponseWeatherResponse(call, response)

        response.body()?.let { onResponseWeatherObject(call, it) }

    }

    protected abstract fun onResponseWeatherResponse(call: retrofit2.Call<S>, response: retrofit2.Response<S>)

    protected abstract fun onResponseWeatherObject(call: retrofit2.Call<S>, response: S)

}