package com.example.android.nigeriaweatherapp.data.repository.dataSource

interface WeatherLocalDataSource {

    suspend fun saveWeatherDataToDB()
    suspend fun getWeatherData()
    suspend fun deleteWeatherData()
}