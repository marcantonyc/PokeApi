package com.example.pokeapi.domain.model

data class PokemonDetail(
    val id: String,
    val name: String,
    val stats: List<PokemonStat>,
    val height: String,
    val weight: String,
)
