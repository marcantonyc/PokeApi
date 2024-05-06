package com.example.pokeapi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import com.example.pokeapi.di.viewmodel.PokemonViewModelFactory
import com.example.pokeapi.ui.pokemon.PokemonIntent
import com.example.pokeapi.ui.pokemon.PokemonViewModel
import com.example.pokeapi.ui.pokemon.components.LoadingComponent
import com.example.pokeapi.ui.pokemon.components.PokemonDetailDialogComponent
import com.example.pokeapi.ui.pokemon.components.PokemonListComponent
import com.example.pokeapi.ui.theme.PokeApiTheme
import com.example.pokeapi.ui.theme.PokedexBg
import javax.inject.Inject


class MainActivity : ComponentActivity() {



    @Inject
    lateinit var pokemonViewModelFactory: PokemonViewModelFactory
    lateinit var pokemonViewModel: PokemonViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (application as PokeApiApplication).applicationComponent.inject(this)

        pokemonViewModel = ViewModelProvider(this, pokemonViewModelFactory)[PokemonViewModel::class.java]
        enableEdgeToEdge()
        setContent {
            PokeApiTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val uiState = pokemonViewModel.uiState.collectAsState().value
                    val onIntent = pokemonViewModel::setIntent


                    Column(
                        Modifier
                            .padding(innerPadding)
                            .background(PokedexBg)) {
                        if(uiState.isListLoading){
                            LoadingComponent()
                            onIntent(PokemonIntent.GetPokemonList)
                        }
                        else{
                            PokemonListComponent(pokemonList = uiState.pokemonList, pokemonViewModel::setIntent )
                        }
                    }

                    if (uiState.isShowDetailDialog){
                        PokemonDetailDialogComponent(pokemon = uiState.pokemonDetail, pokemonViewModel::setIntent)
                    }


                }
            }
        }
    }
}
