package com.example.pokeapi.data.remote.pokemon.list

import com.example.pokeapi.domain.model.PokemonItemList

data class Result(
    val name: String,
    val url: String
)

fun Result.asExternalModel(id: Int) = PokemonItemList(
    name = name,
    url = url,
    id = id
)