package com.example.weatherapplication.dependecy_injection

import com.example.weatherapplication.MainActivity
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [Module::class])
interface ApplicationComponent {
        fun inject(mainActivity: MainActivity)
}