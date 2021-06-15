package com.example.android.nigeriaweatherapp.data.repository.dataSource

import com.example.android.nigeriaweatherapp.data.model.Current
import com.example.android.nigeriaweatherapp.data.model.WeatherResponse
import retrofit2.Response

interface WeatherRemoteDataSource {

    suspend fun getStateWeatherData(lat: Double, lon: Double): Response<Current>


}