package com.example.weatherforecastapp.api

import com.example.weatherforecastapp.model.current.WeatherResponse
import com.example.weatherforecastapp.util.Constants.API_KEY
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    /**
     * [] suspend fun
     * [] @GET annotation for sub-url
     * [] pass query in ctor(value needs to be the same as doc)
     * [] return response
     */
    @GET("/current")
    suspend fun getCurrentWeather( // https://api.weatherstack.com/current?access_key=[]&query=New%20York
        @Query("query") location: String,
        @Query("units") units: String = "m",
        @Query("access_key") apiKey: String = API_KEY
    ): WeatherResponse

    /* paid service
    @GET("/future")
        suspend fun getFutureWeather( // http://api.weatherstack.com/forecast?access_key=[]&query=New%20York&forecast_days=1&hourly=1
            @Query("query") location: String,
            @Query("forecast_days") forecastDays: Int = 7,
            @Query("hourly") hourly: Int = 1,
            @Query("access_key") apiKey: String = API_KEY
        ): FutureWeaather */


}