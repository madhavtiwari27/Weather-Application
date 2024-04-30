package com.example.weatherapplication

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapplication.dataModel.WeatherClassDataModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class WeatherViewModel @Inject constructor(
    private val repo: Repo
) : ViewModel() {

    val weatherDetailLiveData = MutableLiveData<WeatherClassDataModel>()
    val isLoading = MutableLiveData<Boolean>(false)

    fun getWeatherDetail(city : String){
        viewModelScope.launch (Dispatchers.IO){
            isLoading.postValue(true)
            // network request is sent to server , make loader visible
            val response = repo.getWeatherDetail(city)
            if (response.isSuccessful){
                weatherDetailLiveData.postValue(response.body())
                // we have the response from server , make loader invisible
                isLoading.postValue(false)
            }
        }

    }
}