package com.example.firstlab

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

object RetrofitClient {
    private var retrofit: Retrofit? = null

    fun getClient(baseUrl: String): Retrofit {
        if (retrofit == null) {
            retrofit = Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create()).build()
        }
        return retrofit!!
    }
}



object Common {
    private val BASE_URL = "https://api.openweathermap.org/data/2.5/"
    val retrofitService: RetrofitServices get() = RetrofitClient.getClient(BASE_URL).create(RetrofitServices::class.java)
}


interface RetrofitServices {
    //изменить ссылку через переменную для выбора города

    @GET("weather?q=London&appid=df18c33866c3c1316135ba1d01947760&units=metric&lang=ru")
    fun getWeatherList(): Call<MutableList<Root>>
}



data class Root(
    var coord: Coord? = null,
    var weather: ArrayList<Weather>? = null,
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