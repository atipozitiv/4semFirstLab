package com.example.firstlab.retrofit

import androidx.lifecycle.MutableLiveData
import com.example.firstlab.MainActivity
import com.example.firstlab.data.Root
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitServices {
    //изменить ссылку через переменную для выбора города

    @GET("weather?appid=df18c33866c3c1316135ba1d01947760&units=metric&lang=ru")
    fun getWeatherList(@Query("q") city: String): Call<Root>
}