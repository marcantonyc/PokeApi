package com.example.pokeapi.data.remote.pokemon

import com.example.pokeapi.data.remote.pokemon.detail.PokemonDetailResponse
import com.example.pokeapi.data.remote.pokemon.list.PokemonListResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokemonApi {

    @GET("api/v2/pokemon")
    suspend fun getPokemons( @Query("limit") limit: String, @Query("offset") offset: String): PokemonListResponse

    @GET("api/v2/pokemon/{name}")
    suspend fun getPokemonDetail(@Path("name") name: String): PokemonDetailResponse
}