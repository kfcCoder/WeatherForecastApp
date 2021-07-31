package com.example.weatherforecastapp.providers

import com.example.weatherforecastapp.util.UnitSystem

interface UnitProvider {
    fun getUnitSystem(): UnitSystem
}