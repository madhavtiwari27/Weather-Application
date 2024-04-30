package com.example.weatherapplication.dependecy_injection

import com.example.weatherapplication.Repo
import com.example.weatherapplication.dataModel.RetrofitInterface
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class Module {

    @Singleton
    @Provides
    fun provideRetrofit() : Retrofit{
        return Retrofit.Builder().baseUrl("https://api.weatherapi.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideRetrofitServices(retrofit: Retrofit) : RetrofitInterface{
        return retrofit.create(RetrofitInterface::class.java)
    }

    @Singleton
    @Provides
    fun provideRepo(retrofitInterface: RetrofitInterface) : Repo{
        return Repo(retrofitInterface)
    }
}