package com.example.weatherforecastapp.model.future

data class Day(
    val avgtemp: Int,
    val date: String,
    val date_epoch: Int,
    val hourly: List<Hourly>,
    val maxtemp: Int,
    val mintemp: Int,
    val sunhour: Double,
    val totalsnow: Int,
    val uv_index: Int
)