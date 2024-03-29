package com.example.firstlab.data

data class WeatherData(
    var name: String? = null,
    var temp: String? = null,
    var description: String? = null,
    var icon: String? = null
)

data class Root(
    var coord: Coord? = null,
    var weather: MutableList<Weather>? = null,
    var base: String? = null,
    var main: Main? = null,
    var visibility: Int? = 0,
    var wind: Wind? = null,
    var rain: Rain? = null,
    var clouds: Clouds? = null,
    var dt: Int? = 0,
    var sys: Sys? = null,
    var timezone: Int? = 0,
    var id: Int? = 0,
    var name: String? = null,
    var cod: Int? = 0
)
data class Coord(
    var lon: Double? = 0.0,
    var lat: Double? = 0.0
)
data class Weather(
    var id: Int? = 0,
    var main: String? = null,
    var description: String? = null,
    var icon: String? = null
)
data class Main(
    var temp: Double? = 0.0,
    var feels_like: Double? = 0.0,
    var temp_min: Double? = 0.0,
    var temp_max: Double? = 0.0,
    var pressure: Int? = 0,
    var humidity: Int? = 0
)
data class Wind(
    var speed: Double? = 0.0,
    var deg: Int? = 0
)
data class Rain(
    var _1h: Double? = 0.0
)
data class Clouds(
    var all: Int? = 0
)
data class Sys(
    var type: Int? = 0,
    var id: Int? = 0,
    var country: String? = null,
    var sunrise: Int? = 0,
    var sunset: Int? = 0
)