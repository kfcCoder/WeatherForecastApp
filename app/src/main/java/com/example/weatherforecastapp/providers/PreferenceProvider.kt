package com.example.weatherforecastapp.providers

import android.content.Context
import android.content.SharedPreferences
import androidx.preference.PreferenceManager

abstract class PreferenceProvider(context: Context) {
    private val appContext = context.applicationContext

    protected val prefs: SharedPreferences
        = PreferenceManager.getDefaultSharedPreferences(appContext)
}