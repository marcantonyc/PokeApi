package com.example.pokeapi.ui.pokemon

sealed class PokemonEffect {
    data class ShowToast(val message: String): PokemonEffect()
}