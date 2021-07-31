package com.example.weatherforecastapp.data_source

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.weatherforecastapp.api.WeatherApi
import com.example.weatherforecastapp.exception.NoConnectivityException
import com.example.weatherforecastapp.model.current.WeatherResponse
import com.example.weatherforecastapp.util.Constants.TAG
import javax.inject.Inject

class WeatherNetworkDataSourceImpl @Inject constructor (
        private val api: WeatherApi
) : WeatherNetworkDataSource {

    private val _downloadedWeatherResponseLive = MutableLiveData<WeatherResponse>()
    override val downloadedWeatherResponseLive: LiveData<WeatherResponse>
        = _downloadedWeatherResponseLive


    override suspend fun fetchCurrentWeather(
            location: String,
            units: String) {
        try {
            val currentWeather = api
                    .getCurrentWeather(location, units)
            _downloadedWeatherResponseLive.postValue(currentWeather)
            //Log.e(DEBUG, "fetchCurrentWeather: invoked")
        } catch  (e: NoConnectivityException) {
            Log.e(TAG, "No internet connection.", e)
        }
    }
}