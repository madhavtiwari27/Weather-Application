package com.example.weatherapplication.dataModel

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitInterface {

    @GET("/v1/current.json?key=677d4fd4167d4af68e2165225240202")
    suspend fun getWeatherdetail(
        @Query("q")City : String
    ) : Response<WeatherClassDataModel>
}