package com.example.android.nigeriaweatherapp.data.repository.dataSource

import com.example.android.nigeriaweatherapp.data.model.WeatherResponse
import retrofit2.Response

interface WeatherRemoteDataSource {

    suspend fun getWeatherData(
        lat: Double,
        lon: Double,
        exclude: String
    ): Response<WeatherResponse>
}