package com.example.pokeapi.ui.pokemon


sealed class PokemonIntent {
    data object GetPokemonList : PokemonIntent()
    data class OpenPokemonDetail(val name: String): PokemonIntent()
    data object ClosePokemonDetail: PokemonIntent()

}