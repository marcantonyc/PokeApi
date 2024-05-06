package com.example.pokeapi.di.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.pokeapi.domain.model.PokemonDetail
import com.example.pokeapi.domain.use_case.GetPokemonDetailUseCase
import com.example.pokeapi.domain.use_case.GetPokemonListUseCase
import com.example.pokeapi.ui.pokemon.PokemonViewModel
import javax.inject.Inject

class PokemonViewModelFactory @Inject constructor(
    private val getPokemonListUseCase: GetPokemonListUseCase,
    private val getPokemonDetailUseCase: GetPokemonDetailUseCase
) :ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return PokemonViewModel(
            getPokemonListUseCase,
            getPokemonDetailUseCase
            ) as T
    }

}