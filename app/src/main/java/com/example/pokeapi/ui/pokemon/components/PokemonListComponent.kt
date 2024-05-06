package com.example.pokeapi.ui.pokemon.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.rememberLazyStaggeredGridState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.pokeapi.domain.model.PokemonItemList
import com.example.pokeapi.ui.pokemon.PokemonIntent

@Composable
fun PokemonListComponent(pokemonList: List<PokemonItemList>, onIntent: (PokemonIntent) -> Unit){
    val lazyState:  LazyStaggeredGridState = rememberLazyStaggeredGridState()


    LaunchedEffect(lazyState.canScrollForward) {
        if (lazyState.canScrollForward.not() && lazyState.firstVisibleItemIndex > 1) {
           onIntent(PokemonIntent.GetPokemonList)
        }
    }
    LazyVerticalStaggeredGrid(
        state = lazyState,
        columns = StaggeredGridCells.Fixed(3),
        verticalItemSpacing = 12.dp,
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        content = {
            items(pokemonList.size) { index ->
                PokemonItemCardComponent(
                    pokemon =pokemonList[index],
                    onIntent = onIntent,)
            }
            item{}
            item{
                LoadingComponent()
            }
        },
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    )
}