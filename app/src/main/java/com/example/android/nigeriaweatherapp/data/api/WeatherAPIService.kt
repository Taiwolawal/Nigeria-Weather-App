package com.example.android.nigeriaweatherapp.data.api

import com.example.android.nigeriaweatherapp.BuildConfig
import com.example.android.nigeriaweatherapp.data.model.WeatherResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherAPIService {

    @GET("onecall")
    suspend fun getAllWeatherData(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
        @Query("exclude") exclude: String,
        @Query("appid") appid: String = BuildConfig.API_KEY
    ): Response<WeatherResponse>

}