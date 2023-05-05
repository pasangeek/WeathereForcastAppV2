package com.example.weathereforcastappv2.data.db.unitlocalized

interface UnitSpecificCurrentWeatherEntry {
    val temperature: Int
    val windSpeed: Int
    val windDegree: Int
    val windDir: String
    val pressure: Int
    val precip: Double
    val humidity: Int
    val cloudcover: Int
    val feelslike: Int
    val uvIndex: Int
    val visibility: Int
}