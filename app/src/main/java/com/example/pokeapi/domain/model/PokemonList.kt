package com.example.pokeapi.domain.model

data class PokemonList(
    val next: String,
    val previous: Any,
    val list: List<PokemonItemList>
)
