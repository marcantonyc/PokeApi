package com.example.pokeapi.data.remote.pokemon.detail

import com.google.gson.annotations.SerializedName

data class GenerationVi(
    @SerializedName("omegaruby-alphasapphire")
    val omegarubyAalphasapphire: OmegarubyAlphasapphire,
    @SerializedName("x-y")
    val xY: XY
)