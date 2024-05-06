package com.example.pokeapi.di.network

import com.example.pokeapi.data.remote.pokemon.PokemonApi
import com.example.pokeapi.data.repository.PokemonRepositoryImpl
import com.example.pokeapi.domain.repository.PokemonRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Singleton

@Module
abstract class PokemonRepositoryModule {
/*
    @Provides
    @Singleton
    fun providesPokemonRepository(api: PokemonApi, dispatcher: CoroutineDispatcher): PokemonRepository {
        return PokemonRepositoryImpl(api, dispatcher)
    }


 */

    @Binds
    abstract fun bindPokemonRepository(impl: PokemonRepositoryImpl): PokemonRepository
}