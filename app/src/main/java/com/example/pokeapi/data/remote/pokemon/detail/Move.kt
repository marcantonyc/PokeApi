package com.example.pokeapi.data.remote.pokemon.detail

data class Move(
    val move: MoveX,
    val version_group_details: List<VersionGroupDetail>
)