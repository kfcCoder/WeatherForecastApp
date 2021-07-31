package com.example.weatherforecastapp.providers

import com.example.weatherforecastapp.model.current.WeatherLocation

interface LocationProvider {
    suspend fun hasLocationChanged(lastWeatherLocation: WeatherLocation): Boolean
    suspend fun getPreferredLocationString(): String

}