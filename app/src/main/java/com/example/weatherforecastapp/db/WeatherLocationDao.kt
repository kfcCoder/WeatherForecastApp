package com.example.weatherforecastapp.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.weatherforecastapp.model.current.WeatherLocation
import com.example.weatherforecastapp.util.Constants.WEATHER_LOCATION_ID

@Dao
interface WeatherLocationDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsert(weatherLocation: WeatherLocation)

    @Query("SELECT * FROM weather_location where id = $WEATHER_LOCATION_ID")
    fun getLocation(): LiveData<WeatherLocation>

//    @Query("SELECT * FROM weather_location where id = $WEATHER_LOCATION_ID")
//    fun getLocationNonLive(): Location?
}