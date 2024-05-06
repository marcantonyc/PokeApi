package com.example.pokeapi.ui.pokemon.components

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.pokeapi.common.Constants.BASE_SPRITE_URL
import com.example.pokeapi.domain.model.PokemonItemList
import com.example.pokeapi.ui.pokemon.PokemonIntent
import com.example.pokeapi.ui.theme.PokedexItemImageBg

import com.example.pokeapi.ui.theme.PokedexItemTitleBg


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokemonItemCardComponent(
    pokemon: PokemonItemList,
    onIntent: (PokemonIntent) -> Unit,
) {
    Card(
        modifier = Modifier
            .width(200.dp)
            .height(200.dp),
        shape = RoundedCornerShape(8.dp),
        onClick = {
            onIntent(PokemonIntent.OpenPokemonDetail(pokemon.name))
        }
    ) {
        Column(
            Modifier
                .background(PokedexItemTitleBg)
                .padding(8.dp)
                .fillMaxWidth())  {
            Text(
                text = "No.${pokemon.id}",
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Start
            )
            Text(
                text = pokemon.name.replaceFirstChar { it.uppercase() },
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Start
            )

        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(PokedexItemImageBg)
                .padding(0.dp),

            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Column(
                Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                AsyncImage(model = "$BASE_SPRITE_URL/${pokemon.id}.png", contentDescription = pokemon.name,
                    modifier = Modifier.fillMaxSize())
            }

        }
    }
}
