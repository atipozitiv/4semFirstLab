package com.example.firstlab.retrofit

object Common {
    private val BASE_URL = "https://api.openweathermap.org/data/2.5/"
    val retrofitService: RetrofitServices
        get() = RetrofitClient.getClient(BASE_URL).create(RetrofitServices::class.java)
}