package com.example.pokeapi

import android.app.Application
import com.example.pokeapi.di.app.ApplicationComponent
import com.example.pokeapi.di.app.DaggerApplicationComponent

class PokeApiApplication :Application() {
    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        applicationComponent = DaggerApplicationComponent.builder().build()
    }
}