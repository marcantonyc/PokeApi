package com.example.pokeapi.ui.pokemon.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import coil.compose.AsyncImage
import com.example.pokeapi.common.Constants
import com.example.pokeapi.domain.model.PokemonDetail
import com.example.pokeapi.ui.pokemon.PokemonIntent
import com.example.pokeapi.ui.theme.PokedexBg
import com.example.pokeapi.ui.theme.PokedexItemImageBg
import com.example.pokeapi.ui.theme.PokedexItemTitleBg

@Composable
fun PokemonDetailDialogComponent(
    pokemon: PokemonDetail?,
    onIntent: (PokemonIntent) -> Unit
) {
    Dialog(

        onDismissRequest = {
            onIntent(PokemonIntent.ClosePokemonDetail)
        }
    ) {
        Surface(
            color = Color.Transparent,
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                LazyColumn(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .clip(shape = RoundedCornerShape(12.dp))
                        .background(PokedexItemImageBg)
                        .defaultMinSize(minWidth = 200.dp, minHeight = 200.dp),
                    contentPadding = PaddingValues(18.dp)
                )
                {
                    if (pokemon!= null){
                        item {

                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clip(shape = RoundedCornerShape(18.dp))
                                    .background(PokedexItemTitleBg),
                                horizontalArrangement = Arrangement.Center,
                            ) {


                                Text(
                                    text = "No.${pokemon.id}  ${pokemon.name.replaceFirstChar { it.uppercase() }}",
                                    fontSize = 24.sp,
                                    fontWeight = FontWeight.Bold,
                                )

                            }
                        }
                        item{
                            Column(
                                Modifier
                                    .fillMaxWidth()
                                    .height(200.dp),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                AsyncImage(model = "${Constants.BASE_SPRITE_URL}/${pokemon.id}.png", contentDescription = pokemon.name,
                                    modifier = Modifier.fillMaxSize()
                                )
                            }
                        }
                        item{

                            Row(
                                Modifier
                                    .fillMaxWidth()
                                    .clip(shape = RoundedCornerShape(18.dp))
                                    .background(PokedexBg),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ){
                                Spacer(Modifier.width(20.dp))
                                Column {
                                    Text(text = "Height: ${pokemon.height}",
                                        fontSize = 18.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                }


                                Column {
                                    Text(text = "Weight: ${pokemon.weight}",
                                        fontSize = 18.sp,
                                        fontWeight = FontWeight.Bold
                                    )

                                }
                                Spacer(Modifier.width(20.dp))


                            }
                            Spacer(Modifier.height(20.dp))

                        }

                        item{
                            Column(
                                Modifier
                                    .fillMaxWidth()
                                    .clip(shape = RoundedCornerShape(18.dp))
                                    .background(PokedexBg)

                            ) {
                                pokemon.stats.forEach { stat ->
                                    PokemonStatComponent(
                                        statName = stat.name,
                                        statValue = stat.baseStat
                                    )
                                    Spacer(modifier = Modifier.height(8.dp))
                                }
                            }
                        }


                    }
                    else{
                        item{
                            LoadingComponent()
                        }
                    }

                }
                Spacer(modifier = Modifier.height(8.dp))
                Button(onClick = { onIntent(PokemonIntent.ClosePokemonDetail) }) {
                    Text(text = "Volver")
                }
            }
        }
    }
}

