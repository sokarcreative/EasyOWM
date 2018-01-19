package be.sokarcreative.easyowm.api


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