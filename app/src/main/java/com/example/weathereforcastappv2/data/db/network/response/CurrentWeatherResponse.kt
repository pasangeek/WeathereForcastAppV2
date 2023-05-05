package com.example.weathereforcastappv2.data.db.network.response


import com.example.weathereforcastappv2.data.db.entity.Current
import com.example.weathereforcastappv2.data.db.entity.Location

data class CurrentWeatherResponse(

    val location: Location,
    val current: Current
)