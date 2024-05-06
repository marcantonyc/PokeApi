package com.example.pokeapi.domain.repository

import com.example.pokeapi.data.remote.pokemon.detail.PokemonDetailResponse
import com.example.pokeapi.data.remote.pokemon.list.PokemonListResponse

interface PokemonRepository {
    suspend fun getPokemons(limit: String, offset:String): PokemonListResponse
    suspend fun getPokemonDetail(name: String): PokemonDetailResponse
}