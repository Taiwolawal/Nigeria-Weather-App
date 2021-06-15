package com.example.android.nigeriaweatherapp.data.api

import com.example.android.nigeriaweatherapp.BuildConfig
import com.example.android.nigeriaweatherapp.data.model.Current
import com.example.android.nigeriaweatherapp.data.model.WeatherResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherAPIService {

    //https://api.openweathermap.org/data/2.5/onecall?lat={lat}&lon={lon}&exclude={part}&appid={API key}

    @GET("onecall")
    suspend fun stateWeatherData(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
        @Query("exclude") exclude:String = BuildConfig.EXCLUSION,
        @Query("appid") appid: String = BuildConfig.API_KEY
    ): Response<Current>

    //@Query("units") units: String = BuildConfig.TEMPERATURE,

}