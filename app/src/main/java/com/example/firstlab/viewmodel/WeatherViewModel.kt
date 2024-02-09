package com.example.firstlab.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.firstlab.Common
import com.example.firstlab.Root
import com.example.firstlab.data.WeatherData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class WeatherViewModel :ViewModel() {
    val myWeatherData = MutableLiveData<WeatherData>()

    fun GetWeather(){
        var mService = Common.retrofitService
        mService.getWeatherList().enqueue(object: Callback<MutableList<Root>> {
            override fun onFailure(call: Call<MutableList<Root>>, t: Throwable) {

            }
            override fun onResponse(call: Call<MutableList<Root>>, response: Response<MutableList<Root>>) {
                val answer = response.body() as MutableList<Root>
                myWeatherData.value?.name = answer.component1().name
                myWeatherData.value?.temp = answer.component1().main?.temp
                myWeatherData.value?.description = answer.component1().weather?.component1()?.description
                myWeatherData.value?.icon = answer.component1().weather?.component1()?.icon
            }
        })
    }
}