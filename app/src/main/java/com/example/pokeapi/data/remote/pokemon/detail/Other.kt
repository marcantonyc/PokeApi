package com.example.pokeapi.data.remote.pokemon.detail

import com.google.gson.annotations.SerializedName

data class Other(
    val dream_world: DreamWorld,
    val home: Home,
    @SerializedName("official-artwork")
    val officialArtwork: OfficialArtwork,
    val showdown: Showdown
)