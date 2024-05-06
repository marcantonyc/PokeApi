package com.example.pokeapi.data.remote.pokemon.list

import com.example.pokeapi.domain.model.PokemonItemList

data class Result(
    val name: String,
    val url: String
)

fun Result.asExternalModel() = PokemonItemList(
    name = name,
    url = url,
    id = url.substringAfter("pokemon/").substringBefore('/')
)