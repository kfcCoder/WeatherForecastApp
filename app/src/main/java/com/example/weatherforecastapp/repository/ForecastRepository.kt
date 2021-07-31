package com.example.weatherforecastapp.repository

import androidx.lifecycle.LiveData
import com.example.weatherforecastapp.model.current.CurrentWeather
import com.example.weatherforecastapp.model.current.WeatherLocation


interface ForecastRepository {
    suspend fun getCurrentWeather(isMetric: Boolean): LiveData<CurrentWeather>

    suspend fun getWeatherLocation(): LiveData<WeatherLocation>

//    suspend fun getFutureWeatherList(startDate: LocalDate, metric: Boolean): LiveData<out List<UnitSpecificSimpleFutureWeatherEntry>>
//
//    suspend fun getFutureWeatherByDate(date: LocalDate, metric: Boolean): LiveData<out UnitSpecificDetailFutureWeatherEntry>


}