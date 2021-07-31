package com.example.weatherforecastapp.data_source

import androidx.lifecycle.LiveData
import com.example.weatherforecastapp.model.current.WeatherResponse

// used for fetching data from network and handling exception
interface WeatherNetworkDataSource {
    val downloadedWeatherResponseLive: LiveData<WeatherResponse>

    //val downloadedFutureWeather: LiveData<FutureWeatherResponse>


    suspend fun fetchCurrentWeather(
        location: String,
        units: String = "m"
    )


//    suspend fun fetchFutureWeather(
//            location: String,
//            languageCode: String
//    )

}