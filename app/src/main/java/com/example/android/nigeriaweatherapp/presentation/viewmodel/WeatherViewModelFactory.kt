package com.example.android.nigeriaweatherapp.presentation.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.android.nigeriaweatherapp.domain.usecase.GetStateWeatherUseCase

@Suppress("UNCHECKED_CAST")
class WeatherViewModelFactory (private val app: Application,
                               private val getStateWeatherUseCase: GetStateWeatherUseCase
): ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return WeatherViewModel(app, getStateWeatherUseCase) as T
    }
}