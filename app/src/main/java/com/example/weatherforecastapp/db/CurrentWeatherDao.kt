package com.example.weatherforecastapp.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.weatherforecastapp.model.current.CurrentWeather
import com.example.weatherforecastapp.util.Constants.CURRENT_WEATHER_ID

@Dao
interface CurrentWeatherDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsert(entry: CurrentWeather): Long

    @Query("SELECT * FROM current_weather WHERE id = ${CURRENT_WEATHER_ID}")
    fun getWeather(): LiveData<CurrentWeather>
}