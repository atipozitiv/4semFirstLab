package com.example.firstlab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.firstlab.data.Root
import com.example.firstlab.retrofit.Common
import com.example.firstlab.retrofit.RetrofitServices
import com.example.firstlab.viewmodel.WeatherViewModel
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.Query

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val myButton: Button = findViewById(R.id.myButton)
        val nameText: TextView = findViewById(R.id.nameText)
        val tempText: TextView = findViewById(R.id.tempText)
        val descText: TextView = findViewById(R.id.descText)
        val image: ImageView = findViewById(R.id.myImage)
        val editText: EditText = findViewById(R.id.myEdit)
        var myViewModel: WeatherViewModel

        myViewModel = ViewModelProvider(this).get(WeatherViewModel::class.java)

        myButton.setOnClickListener {
            var myCity: String = editText.text.toString()
            myViewModel.GetWeather(myCity)
        }
        myViewModel.myWeatherData.observe(this, Observer {
            nameText.text = it.name
            tempText.text = it.temp
            descText.text = it.description
            Picasso.get().load("https://openweathermap.org/img/wn/" + it.icon + "@2x.png").into(image)
        })
    }
}

