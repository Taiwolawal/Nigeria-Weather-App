package com.example.android.nigeriaweatherapp

import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.android.nigeriaweatherapp.data.model.Current
import com.example.android.nigeriaweatherapp.data.model.State
import com.example.android.nigeriaweatherapp.data.model.Weather
import com.example.android.nigeriaweatherapp.data.util.Resource
import com.example.android.nigeriaweatherapp.databinding.ActivityMainBinding
import com.example.android.nigeriaweatherapp.presentation.viewmodel.WeatherViewModel
import com.example.android.nigeriaweatherapp.presentation.viewmodel.WeatherViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var stateSpinner: Spinner
    private lateinit var searchWeatherButton: Button
    private lateinit var binding: ActivityMainBinding
    lateinit var viewModel: WeatherViewModel
    lateinit var factory: WeatherViewModelFactory
    private var states: MutableList<State> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this, factory).get(WeatherViewModel::class.java)

        searchWeatherButton = binding.weatherLayoutInput.weatherButton

        stateSpinner = binding.weatherLayoutInput.stateSpinner
        ArrayAdapter.createFromResource(
            this,
            R.array.states_list_filter,
            android.R.layout.simple_spinner_item
        )
            .also { adapter ->
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                stateSpinner.adapter = adapter
            }

        searchWeatherButton.setOnClickListener {
            val stateId = stateSpinner.selectedItemPosition

        }


    }

    private fun viewTodayWeatherInfo() {
        viewModel.getStateWeatherInfo(9.3265, 12.3984)
        viewModel.stateWeatherInfo.observe(this, { response ->
            when (response) {
                is Resource.Loading -> {
                    showProgressBar()
                }
                is Resource.Success -> {
                    hideProgressBar()
                    response.data?.let {
                        displayWeatherInfo(it)
                    }

                }
                is Resource.Error -> {
                    hideProgressBar()
                    response.message?.let {
                        Toast.makeText(this, "No internet connection", Toast.LENGTH_LONG).show()
                    }
                }
            }


        })
    }

    private fun showProgressBar() {
        binding.progressBar.visibility = View.VISIBLE
    }

    private fun hideProgressBar() {
        binding.progressBar.visibility = View.INVISIBLE
    }

    private fun displayWeatherInfo(current: Current) {
        binding.weatherLayoutBasic.weatherDateAndTime.text = current.dt.toString()
        binding.weatherLayoutBasic.weatherTemperatureCelsius.text = current.temp.toString()
        binding.weatherLayoutBasic.tvWeatherCondition.text = current.weather[0].description
        val posterURL = "https://image.tmdb.org/t/p/w500${current.weather[0].icon}.png"
        Glide.with(binding.weatherLayoutBasic.ivWeatherCondition.context).load(posterURL)
            .into(binding.weatherLayoutBasic.ivWeatherCondition)
    }

    //val weatherData = WeatherData(
    //                    dateTime = data.dt.unixTimestampToDateTimeString(),
    //                    temperature = data.main.temp.kelvinToCelsius().toString(),
    //                    cityAndCountry = "${data.name}, ${data.sys.country}",
    //                    weatherConditionIconUrl = "http://openweathermap.org/img/w/${data.weather[0].icon}.png",
    //                    weatherConditionIconDescription = data.weather[0].description,
    //                    humidity = "${data.main.humidity}%",
    //                    pressure = "${data.main.pressure} mBar",
    //                    visibility = "${data.visibility/1000.0} KM",
    //                    sunrise = data.sys.sunrise.unixTimestampToTimeString(),
    //                    sunset = data.sys.sunset.unixTimestampToTimeString()
    //                )


}