package com.example.pokeapi.data.remote.pokemon.detail

import com.example.pokeapi.domain.model.PokemonDetail
import com.example.pokeapi.domain.model.PokemonStat

data class PokemonDetailResponse(
    val abilities: List<Ability>,
    val base_experience: Int,
    val cries: Cries,
    val forms: List<Form>,
    val game_indices: List<GameIndice>,
    val height: Int,
    val held_items: List<HeldItem>,
    val id: Int,
    val is_default: Boolean,
    val location_area_encounters: String,
    val moves: List<Move>,
    val name: String,
    val order: Int,
    val past_abilities: List<Any>,
    val past_types: List<Any>,
    val species: Species,
    val sprites: Sprites,
    val stats: List<Stat>,
    val types: List<Type>,
    val weight: Int
)

fun PokemonDetailResponse.asExternalModel() = PokemonDetail(
    id = id.toString(),
    name= name,
    stats = stats.map { PokemonStat(baseStat = it.base_stat, name = it.stat.name) },
    height = height.toString() ,
    weight = weight.toString()


)