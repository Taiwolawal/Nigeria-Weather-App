package com.example.android.nigeriaweatherapp.data.repository

import com.example.android.nigeriaweatherapp.data.model.Current
import com.example.android.nigeriaweatherapp.data.model.WeatherResponse
import com.example.android.nigeriaweatherapp.data.repository.dataSource.WeatherRemoteDataSource
import com.example.android.nigeriaweatherapp.data.util.Resource
import com.example.android.nigeriaweatherapp.domain.repository.WeatherRepository
import retrofit2.Response

class WeatherRepositoryImpl(private val remoteDataSource: WeatherRemoteDataSource): WeatherRepository {

    override suspend fun getStateWeatherData(lat: Double, lon: Double): Resource<Current> {
        return responseToResource(remoteDataSource.getStateWeatherData(lat, lon))
    }


    private fun responseToResource(response: Response<Current>): Resource<Current>{
        if (response.isSuccessful) {
            response.body()?.let { result->
                return Resource.Success(result)
            }
        }
        return Resource.Error(response.message())
    }


    override suspend fun getAllStatesWeather() {
        TODO("Not yet implemented")


    }

    override suspend fun getSavedStatesWeather() {
        TODO("Not yet implemented")
    }

    override suspend fun saveStateWeather() {
        TODO("Not yet implemented")
    }


}