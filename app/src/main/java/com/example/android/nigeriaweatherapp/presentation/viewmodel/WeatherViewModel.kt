package com.example.android.nigeriaweatherapp.presentation.viewmodel

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android.nigeriaweatherapp.data.model.Current
import com.example.android.nigeriaweatherapp.data.model.State
import com.example.android.nigeriaweatherapp.data.model.WeatherResponse
import com.example.android.nigeriaweatherapp.data.util.Resource
import com.example.android.nigeriaweatherapp.domain.usecase.GetStateWeatherUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

class WeatherViewModel(private val app: Application,
                       private val weatherUseCase: GetStateWeatherUseCase): AndroidViewModel(app) {

    val abia = State(9.3265, 12.3984)

    val stateWeatherInfo: MutableLiveData<Resource<Current>> = MutableLiveData()

    fun getStateWeatherInfo(lan: Double, lon: Double) = viewModelScope.launch(Dispatchers.IO) {
        stateWeatherInfo.postValue(Resource.Loading())
        try{
            if(isNetworkAvailable(app)){
                val result = weatherUseCase.execute(lan, lon)
                Log.i("Network", "getStateWeatherInfo: $result")
                stateWeatherInfo.postValue(result)
            }
        }
        catch (e: Exception){

        }
        val result =  weatherUseCase.execute(lan, lon)

    }

//    fun getStateLatitudeAndLongitude(id: Int){
//        val number = state.state[id]
//        number.lat
//    }

    private fun isNetworkAvailable(context: Context?):Boolean{
        if (context == null) return false
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            val capabilities = connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
            if (capabilities != null) {
                when {
                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> {
                        return true
                    }
                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> {
                        return true
                    }
                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> {
                        return true
                    }
                }
            }
        } else {
            val activeNetworkInfo = connectivityManager.activeNetworkInfo
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected) {
                return true
            }
        }
        return false

    }


}