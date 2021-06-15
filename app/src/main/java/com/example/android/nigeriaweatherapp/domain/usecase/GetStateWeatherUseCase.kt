package com.example.android.nigeriaweatherapp.domain.usecase

import com.example.android.nigeriaweatherapp.domain.repository.WeatherRepository

class GetStateWeatherUseCase (private val weatherRepository: WeatherRepository){

    suspend fun execute (lan: Double, lon: Double) =
        weatherRepository.getStateWeatherData(lon, lon)
}