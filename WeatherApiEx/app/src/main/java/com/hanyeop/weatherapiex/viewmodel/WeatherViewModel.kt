package com.hanyeop.weatherapiex.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hanyeop.weatherapiex.model.Weather
import com.hanyeop.weatherapiex.repository.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val repository: WeatherRepository
) : ViewModel() {

    private val _weatherResponse : MutableLiveData<Response<Weather>> = MutableLiveData()
    val weatherResponse get() = _weatherResponse

    fun getWeather(dataType : String, numOfRows : Int, pageNo : Int,
                   baseDate : Int, baseTime : Int, nx : String, ny : String){
        viewModelScope.launch {
            val response = repository.getWeather(dataType, numOfRows, pageNo, baseDate, baseTime, nx, ny)
            _weatherResponse.value = response
        }
    }
}