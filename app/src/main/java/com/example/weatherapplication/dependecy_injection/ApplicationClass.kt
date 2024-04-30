package com.example.weatherapplication.dependecy_injection

import android.app.Application


class ApplicationClass : Application() {

    lateinit var applicationComponent : ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        applicationComponent = DaggerApplicationComponent.builder()
            .module(Module()) // Add this line to provide the required module
            .build()
    }
}