package com.example.weathereforcastappv2.data


import com.google.gson.annotations.SerializedName

data class CurrentWeatherResponse(
    val request: Request,
    val location: Location,
@SerializedName("current")
    val current: CurrentWeatherEntry
)