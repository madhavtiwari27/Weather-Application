package com.example.weatherapplication

import com.example.weatherapplication.dataModel.RetrofitInterface
import javax.inject.Inject

class Repo @Inject constructor(
    private val retrofitInterface: RetrofitInterface
){

    suspend fun getWeatherDetail(city : String) = retrofitInterface.getWeatherdetail(city)
}