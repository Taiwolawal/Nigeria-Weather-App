package com.example.android.nigeriaweatherapp.data.repository.datasSourceimpl

import com.example.android.nigeriaweatherapp.data.db.DailyWeatherDAO
import com.example.android.nigeriaweatherapp.data.model.Daily
import com.example.android.nigeriaweatherapp.data.repository.dataSource.WeatherLocalDataSource
import kotlinx.coroutines.flow.Flow

class WeatherLocalDataSourceImpl(private val weatherDAO: DailyWeatherDAO) : WeatherLocalDataSource {
    override suspend fun saveDailyWeatherDataToDB(daily: Daily) {
       weatherDAO.insert(daily)
    }

    override  fun getDailyWeatherData(): Flow<List<Daily>> {
        return  weatherDAO.getAllDailyWeather()
    }

    override suspend fun deleteAllWeatherStat() {
        weatherDAO.deleteAllWeatherStat()
    }

    override suspend fun deleteDailyWeatherData(daily: Daily) {
       weatherDAO.deleteDailyWeather(daily)
    }
}