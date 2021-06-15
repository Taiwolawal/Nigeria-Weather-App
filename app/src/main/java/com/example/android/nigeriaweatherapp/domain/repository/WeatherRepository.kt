package com.example.android.nigeriaweatherapp.domain.repository

import com.example.android.nigeriaweatherapp.data.model.Current
import com.example.android.nigeriaweatherapp.data.model.WeatherResponse
import com.example.android.nigeriaweatherapp.data.util.Resource
import retrofit2.Response

interface WeatherRepository {

    suspend fun getStateWeatherData(lat: Double, lon: Double,): Resource<Current>

    suspend fun getAllStatesWeather()

    suspend fun getSavedStatesWeather()

    suspend fun  saveStateWeather()
}