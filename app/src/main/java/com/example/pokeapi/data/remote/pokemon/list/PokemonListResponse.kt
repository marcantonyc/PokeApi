package com.example.pokeapi.data.remote.pokemon.list

data class PokemonListResponse(
    val count: Int,
    val next: String,
    val previous: String?,
    val results: List<Result>
)