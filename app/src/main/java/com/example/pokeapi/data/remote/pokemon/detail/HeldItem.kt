package com.example.pokeapi.data.remote.pokemon.detail

data class HeldItem(
    val item: Item,
    val version_details: List<VersionDetail>
)