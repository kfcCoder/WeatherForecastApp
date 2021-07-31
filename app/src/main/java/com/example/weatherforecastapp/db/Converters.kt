package com.example.weatherforecastapp.db

import androidx.room.TypeConverter

class Converters {
    @TypeConverter
    fun fromIcons(list: List<String>): String {
        return list[0]
    }

    @TypeConverter
    fun toIcons(s: String): List<String> {
        return mutableListOf(s)
    }


    /* 同類型的Converter只能有一種
    @TypeConverter
    fun fromDescriptions(list: List<String>): String {
        return list[0]
    }

    @TypeConverter
    fun toDescriptions(s: String): List<String> {
        return mutableListOf(s)
    }*/



}