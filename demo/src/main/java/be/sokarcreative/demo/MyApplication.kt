package be.sokarcreative.demo

import android.app.Application

/**
 * Created by sokarcreative on 19/01/2018.
 */

/**
 * Created by sokarcreative on 12/12/2017.
 */
class MyApplication : Application(){

    val component: AppComponent by lazy {
        DaggerAppComponent.builder().appModule(AppModule(this)).build()
    }

    override fun onCreate() {
        super.onCreate()
        component.inject(this)
    }

}