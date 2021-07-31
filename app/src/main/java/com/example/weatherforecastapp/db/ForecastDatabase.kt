package com.example.weatherforecastapp.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.weatherforecastapp.model.current.CurrentWeather
import com.example.weatherforecastapp.model.current.WeatherLocation


/**
 * [x] provider in Module
 */
@Database(
        entities = [CurrentWeather::class,
                    WeatherLocation::class],
        version = 1,
        exportSchema = false
)

@TypeConverters(Converters::class)
abstract class ForecastDatabase : RoomDatabase() {
    abstract fun getCurrentWeatherDao(): CurrentWeatherDao
    abstract fun getWeatherLocationDao(): WeatherLocationDao

    // Dagger will take care of the rest house keeping stuff...

    /*companion object {
        @Volatile
        private var instance: ForecastDatabase? = null

        fun getDatabase(context: Context): ForecastDatabase {
            return instance ?: synchronized(this) {
                instance ?: createDataBase(context).also { instance = it}
            }
        }

        // @params: #Context instance
        private fun createDataBase(context: Context) =
                Room.databaseBuilder(
                        context.applicationContext,
                        ForecastDatabase::class.java,
                        "test_db"
                ).build()

    }*/


}