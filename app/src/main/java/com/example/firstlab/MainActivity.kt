package com.example.firstlab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.firstlab.viewmodel.WeatherViewModel
import com.squareup.picasso.Picasso

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my)

        val myButton: Button = findViewById(R.id.myButton)
        val nameText: TextView = findViewById(R.id.nameText)
        val tempText: TextView = findViewById(R.id.tempText)
        val descText: TextView = findViewById(R.id.descText)
        val image: ImageView = findViewById(R.id.myImage)
        val editText: EditText = findViewById(R.id.myEdit)

        var myViewModel: WeatherViewModel
        myViewModel = ViewModelProvider(this).get(WeatherViewModel::class.java)
        myViewModel.myWeatherData.observe(this, Observer {
            nameText.text = myViewModel.myWeatherData.value?.name
            tempText.text = myViewModel.myWeatherData.value?.temp.toString()
            descText.text = myViewModel.myWeatherData.value?.description
            Picasso.get().load("https://openweathermap.org/img/wn/" + myViewModel.myWeatherData.value?.temp + "@2x.png").into(image)
        })

        myButton.setOnClickListener {
            var myCity: String = editText.text.toString()
            myViewModel.GetWeather()
            nameText.text = myViewModel.myWeatherData.value?.name.toString()
        }
    }
}

