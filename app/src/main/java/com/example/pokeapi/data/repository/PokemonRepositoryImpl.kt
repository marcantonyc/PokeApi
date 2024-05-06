package com.example.pokeapi.data.repository

import com.example.pokeapi.data.remote.pokemon.PokemonApi
import com.example.pokeapi.data.remote.pokemon.detail.PokemonDetailResponse
import com.example.pokeapi.data.remote.pokemon.list.PokemonListResponse
import com.example.pokeapi.di.coroutines.IoDispatcher
import com.example.pokeapi.domain.model.PokemonDetail
import com.example.pokeapi.domain.repository.PokemonRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

import javax.inject.Inject

class PokemonRepositoryImpl @Inject constructor(
     private val api: PokemonApi,
     @IoDispatcher private val dispatcher: CoroutineDispatcher

): PokemonRepository {

    override suspend fun getPokemons(limit: String, offset: String): PokemonListResponse {
        return withContext(dispatcher){
            delay(2000) // used to show loading states
            api.getPokemons(
                limit = limit,
                offset = offset
            )
        }
    }
    override suspend fun getPokemonDetail(name: String): PokemonDetailResponse {
        return withContext(dispatcher){
            delay(2000) // used to show loading states
            api.getPokemonDetail(name)
        }
    }

}