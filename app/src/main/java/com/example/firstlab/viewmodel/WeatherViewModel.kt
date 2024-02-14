package com.example.firstlab.viewmodel

import android.app.Application
import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.firstlab.data.Root
import com.example.firstlab.retrofit.Common
import com.example.firstlab.data.WeatherData
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class WeatherViewModel(application: Application) : AndroidViewModel(application) {
    var myWeatherData = MutableLiveData<WeatherData>()

    fun GetWeather(city: String) {
        var mService = Common.retrofitService
        mService.getWeatherList(city).enqueue(object: Callback<Root> {
            override fun onFailure(call: Call<Root>, t: Throwable) {
                Toast.makeText(getApplication(), "Ошибка", Toast.LENGTH_LONG).show()
            }
            override fun onResponse(call: Call<Root>, response: Response<Root>) {
                val answer = response.body() as Root
                var secAnswer:WeatherData = WeatherData()
                secAnswer.name = answer.name
                secAnswer.temp = answer.main?.temp.toString()
                secAnswer.description = answer.weather?.component1()?.description
                secAnswer.icon = answer.weather?.component1()?.icon
                Toast.makeText(getApplication(), secAnswer.name.toString(), Toast.LENGTH_LONG).show()
                myWeatherData.value = secAnswer
                Toast.makeText(getApplication(), myWeatherData.value?.name.toString(), Toast.LENGTH_LONG).show()
            }
        })
    }
}