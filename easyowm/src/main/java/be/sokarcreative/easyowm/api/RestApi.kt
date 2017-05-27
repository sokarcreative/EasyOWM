package be.sokarcreative.easyowm.api

import okhttp3.Interceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import java.io.IOException




/**
 * Created by sokarcreative on 25/05/2017.
 * Contact : marinx.denis@gmail.com
 */
class RestApi{
    private object Holder { val INSTANCE = RestApi() }
    companion object {
        val instance: RestApi by lazy { Holder.INSTANCE }
    }

    val openWeatherMapApi: OpenWeatherMapApi
    init {
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)

        val headerInterceptor = object : Interceptor {
            @Throws(IOException::class)
            override fun intercept(chain: Interceptor.Chain): Response {
                val original = chain.request()
                val builder = original.newBuilder()
                builder.method(original.method(), original.body())

                val request = builder.build()

                return chain.proceed(request)
            }
        }
        val httpClient = OkHttpClient.Builder()
                .addInterceptor(headerInterceptor)
                .addInterceptor(logging)
                .build()
        val retrofit = Retrofit.Builder()
                .baseUrl("http://api.openweathermap.org/data/2.5/")
                .addConverterFactory(MoshiConverterFactory.create())
                .client(httpClient)
                .build()

        openWeatherMapApi = retrofit.create(OpenWeatherMapApi::class.java)
    }
}
