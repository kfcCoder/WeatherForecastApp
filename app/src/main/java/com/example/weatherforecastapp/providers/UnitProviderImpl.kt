package com.example.weatherforecastapp.providers

import android.content.Context
import com.example.weatherforecastapp.util.Constants.UNIT_SYSTEM
import com.example.weatherforecastapp.util.UnitSystem
import javax.inject.Inject

class UnitProviderImpl @Inject constructor (
        context: Context
) : PreferenceProvider(context), UnitProvider {

    /**
     * 1. get string from #SharedPreferences
     * 2. turns the string to enum class
     */
    override fun getUnitSystem(): UnitSystem {
        val unitString = prefs.getString(UNIT_SYSTEM, UnitSystem.METRIC.name) // get a string
        return UnitSystem.valueOf(unitString!!) // turns it into enum class
    }
}