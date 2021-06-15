package com.example.android.nigeriaweatherapp.data.repository.dataSource

import com.example.android.nigeriaweatherapp.data.model.Daily
import kotlinx.coroutines.flow.Flow

interface WeatherLocalDataSource {

    suspend fun saveDailyWeatherDataToDB(daily: Daily)

     fun getDailyWeatherData(): Flow<List<Daily>>

    suspend fun deleteAllWeatherStat()

    suspend fun deleteDailyWeatherData(daily: Daily)
}