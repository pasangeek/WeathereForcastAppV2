package com.example.weathereforcastappv2.data.response


import com.google.gson.annotations.SerializedName

data class CurrentWeatherResponse(

    val location: Location,
    val current: Current
)