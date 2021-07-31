package com.example.weatherforecastapp.retrofit

import com.example.weatherforecastapp.api.WeatherApi
import com.example.weatherforecastapp.util.Constants.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * [] setup base url
 * [] get network connection of desired api
 */
object WeatherStackRetrofit {

    private val retrofit by lazy {
        Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

    val API: WeatherApi by lazy {
        retrofit.create(WeatherApi::class.java)
    }
}