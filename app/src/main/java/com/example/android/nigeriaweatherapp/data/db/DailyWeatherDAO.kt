package com.example.android.nigeriaweatherapp.data.db

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.android.nigeriaweatherapp.data.model.Daily
import kotlinx.coroutines.flow.Flow

interface DailyWeatherDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(daily: Daily)

    @Query("SELECT * FROM daily_temperature")
    fun getAllDailyWeather(): Flow<List<Daily>>

    @Delete
    suspend fun deleteDailyWeather(daily: Daily)

    @Query("DELETE FROM daily_temperature" )
    suspend fun deleteAllWeatherStat()
}