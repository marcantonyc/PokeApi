package com.example.pokeapi.ui.pokemon

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.pokeapi.common.Resource
import com.example.pokeapi.domain.model.PokemonDetail
import com.example.pokeapi.domain.use_case.GetPokemonDetailUseCase
import com.example.pokeapi.domain.use_case.GetPokemonListUseCase
import com.example.pokeapi.ui.base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class PokemonViewModel @Inject constructor(
    private val getPokemonListUseCase: GetPokemonListUseCase,
    private val getPokemonDetailUseCase: GetPokemonDetailUseCase

): BaseViewModel<PokemonUiState, PokemonEffect, PokemonIntent>() {

    private val limit = 30

    val offset: LiveData<Int> get() = _offset
    private var _offset = MutableLiveData(0)



    override fun createInitialState(): PokemonUiState {
        return PokemonUiState(isListLoading = true)
    }

    override fun handleIntent(intent: PokemonIntent) {
        when(intent){
            is PokemonIntent.GetPokemonList -> getPokemonList()
            is PokemonIntent.OpenPokemonDetail -> openPokemonDetail(intent.name)
            is PokemonIntent.ClosePokemonDetail -> closePokemonDetail()
        }
    }


    fun getPokemonList(){
        viewModelScope.launch(Dispatchers.IO) {
            setState { copy(isListLoading = true) }
            getPokemonListUseCase(
                limit = limit.toString(),
                offset = offset.value.toString(),
            ).collect{
                when(it){
                    is Resource.Success -> {
                        setState {
                            copy(
                                isListLoading = false,
                                pokemonList = it.data?.list?: emptyList()
                            )
                        }

                    }
                    is Resource.Loading -> {
                        setState {
                            copy(
                                isListLoading = true
                            )
                        }
                    }
                    is Resource.Error -> {
                        setState {
                            copy(
                                isListLoading = false
                            )
                        }
                        setEvent {
                            PokemonEffect.ShowToast("Error ")
                        }
                    }
                }
            }

        }
    }

    fun openPokemonDetail(name: String) {
        Log.d("mki","show $name")
        viewModelScope.launch(Dispatchers.IO){
            setState { copy(
                isShowDetailDialog = true,
            ) }

            getPokemonDetailUseCase(
                name = name
            ).collect{
                when(it){
                    is Resource.Success -> {
                        Log.d("MKI", "RESOURCE.STATE -> Success ")
                        setState {
                            copy(
                                isListLoading = false,
                                pokemonDetail = it.data
                            )
                        }
                    }
                    is Resource.Loading -> {
                        setState {
                            copy(
                                isDetailLoading = true
                            )
                        }
                    }
                    is Resource.Error -> {
                        setState {
                            copy(
                                isDetailLoading = false
                            )
                        }
                        setEvent {
                            PokemonEffect.ShowToast("Error Detail Pokemon $name ")
                        }
                    }
                }
            }
        }
    }

    fun closePokemonDetail(){
        setState {
            copy(
                pokemonDetail = null,
                isDetailLoading = false,
                isShowDetailDialog = false

            )
        }
    }

}