package com.example.pokeapi.di.app

import com.example.pokeapi.MainActivity
import com.example.pokeapi.di.coroutines.CoroutineDispatcherModule
import com.example.pokeapi.di.coroutines.CoroutineScopeModule
import com.example.pokeapi.di.network.NetworkModule
import com.example.pokeapi.di.network.PokemonRepositoryModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    NetworkModule::class,
    //CoroutineScopeModule::class,
    CoroutineDispatcherModule::class,
    PokemonRepositoryModule::class,
])
interface ApplicationComponent {

    fun inject(mainActivity: MainActivity)
}