package com.example.weatherforecastapp.repository

import androidx.lifecycle.LiveData
import com.example.weatherforecastapp.data_source.WeatherNetworkDataSource
import com.example.weatherforecastapp.db.CurrentWeatherDao
import com.example.weatherforecastapp.db.WeatherLocationDao
import com.example.weatherforecastapp.model.current.CurrentWeather
import com.example.weatherforecastapp.model.current.WeatherLocation
import com.example.weatherforecastapp.model.current.WeatherResponse
import com.example.weatherforecastapp.providers.LocationProvider
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.threeten.bp.ZonedDateTime
import javax.inject.Inject

/**
 *
 *
 */
class ForecastRepositoryImpl @Inject constructor (
        private val currentWeatherDao: CurrentWeatherDao,
        private val weatherLocationDao: WeatherLocationDao,
        private val weatherNetworkDataSource: WeatherNetworkDataSource,
        private val locationProvider: LocationProvider
) : ForecastRepository {
    // observe weatherDataSource when creation
    init {
        weatherNetworkDataSource.downloadedWeatherResponseLive.observeForever {
            persistFetchedCurrentWeather(it) // if a new weather is fetched, then cache it in db
        }
    }

    // persist newly fetched current weather to db
    private fun persistFetchedCurrentWeather(fetchedWeather: WeatherResponse) {
        GlobalScope.launch(IO) {
            currentWeatherDao.upsert(fetchedWeather.currentWeather)
            weatherLocationDao.upsert(fetchedWeather.weatherLocation)
        }
    }

    // init weather data and return LiveData in db to ViewModel
    override suspend fun getCurrentWeather(isMetric: Boolean): LiveData<CurrentWeather> {
        return withContext(IO) {
            initWeatherData(isMetric)
            currentWeatherDao.getWeather() // in order to work sequentially
        }
    }

    // determine is fetch data needed or not
    private suspend fun initWeatherData(isMetric: Boolean) {
        val lastWeatherLocation = weatherLocationDao.getLocation().value

        if (isFetchedCurrentNeeded(ZonedDateTime.now().minusHours(1))) {
            fetchCurrentWeather(isMetric)
        }

        if (lastWeatherLocation == null  // i.e. first time launch app, nothing in db
                || locationProvider.hasLocationChanged(lastWeatherLocation)) {
            fetchCurrentWeather(isMetric)
            return
        }
//
//        if (isFetchedCurrentNeeded(lastWeatherLocation.zonedDateTime)) {
//            fetchCurrentWeather(isMetric)
//        }
    }

    // calling #WeatherNetworkDataSource @fetchCurrentWeather()
    private suspend fun fetchCurrentWeather(isMetric: Boolean) {
        val metric = if (isMetric) "m" else "f"
        weatherNetworkDataSource.fetchCurrentWeather(
                locationProvider.getPreferredLocationString(),
                //"Taipei",
                metric
        )
    }


    // 'true' if lastFetchTime is 30 mins ago
    private fun isFetchedCurrentNeeded(lastFetchTime: ZonedDateTime): Boolean {
        val thirtyMinutesAgo = ZonedDateTime.now().minusMinutes(30)
        return lastFetchTime.isBefore(thirtyMinutesAgo)
    }

    /* Weather Location */
    override suspend fun getWeatherLocation(): LiveData<WeatherLocation> {
        return withContext(IO) {
            weatherLocationDao.getLocation()
        }
    }



}