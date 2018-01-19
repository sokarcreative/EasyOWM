package be.sokarcreative.demo

import android.content.Context
import be.sokarcreative.easyowm.api.OpenWeatherMap
import dagger.Component
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import java.io.IOException
import javax.inject.Singleton

/**
 * Created by sokarcreative on 19/01/2018.
 */
@Module
class AppModule constructor(private val context: Context) {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
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

        return OkHttpClient.Builder()
                .addInterceptor(headerInterceptor)
                .addInterceptor(logging)
                .build()
    }

    @Provides
    @Singleton
    fun provideRestApi(okHttpClient: OkHttpClient): OpenWeatherMap = OpenWeatherMap(okHttpClient, BuildConfig.OWM_API_KEY)

}

@Singleton
@Component(modules = [(AppModule::class)])
interface AppComponent {
    fun inject(app: MyApplication)
    fun inject(activity: MainActivity)
}