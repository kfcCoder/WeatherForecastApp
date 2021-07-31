package com.example.weatherforecastapp.viewmodel

import androidx.lifecycle.*
import com.example.weatherforecastapp.model.current.CurrentWeather
import com.example.weatherforecastapp.model.current.WeatherLocation
import com.example.weatherforecastapp.providers.UnitProvider
import com.example.weatherforecastapp.repository.ForecastRepository
import com.example.weatherforecastapp.util.UnitSystem
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CurrentWeatherViewModel @Inject constructor (
        private val forecastRepo: ForecastRepository,
        unitProvider: UnitProvider
) : ViewModel() {

    private val unitSystem: UnitSystem
        = unitProvider.getUnitSystem()


    val isMetric: Boolean
        = (unitSystem == UnitSystem.METRIC)


    suspend fun getCurrentWeather(): LiveData<CurrentWeather> {
        return forecastRepo.getCurrentWeather(isMetric)
    }

    /* 也可以
    val weather by lazyDeferred {
        forecastRepo.getCurrentWeather(isMetric)
    }*/


    suspend fun getWeatherLocation(): LiveData<WeatherLocation> {
        return forecastRepo.getWeatherLocation()
    }





}

