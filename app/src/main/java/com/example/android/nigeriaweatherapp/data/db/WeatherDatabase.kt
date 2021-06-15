package com.example.android.nigeriaweatherapp.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.android.nigeriaweatherapp.data.model.Daily

@Database(entities = [Daily::class], version = 1, exportSchema = false)
abstract class WeatherDatabase: RoomDatabase() {
    abstract  fun getDailyWeatherDAO(): DailyWeatherDAO
}