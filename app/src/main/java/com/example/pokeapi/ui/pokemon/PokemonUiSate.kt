package com.example.pokeapi.ui.pokemon

import com.example.pokeapi.domain.model.PokemonDetail
import com.example.pokeapi.domain.model.PokemonItemList

data class PokemonUiState(
    val pokemonList: List<PokemonItemList> = emptyList(),
    val isListLoading: Boolean = false,
    val pokemonDetail: PokemonDetail? = null,
    val isShowDetailDialog: Boolean = false,
    val isDetailLoading: Boolean = false,
    val errorMessage: String? = null,
)