package com.example.android.nigeriaweatherapp.domain.repository

interface WeatherRepository {

    suspend fun  getStateWeather()

    suspend fun getAllStatesWeather()

    suspend fun getSavedStatesWeather()

    suspend fun  saveStateWeather()
}