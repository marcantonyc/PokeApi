package com.example.pokeapi.ui.pokemon.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pokeapi.ui.theme.PokemonDetailGray
import com.example.pokeapi.ui.theme.statsColorMap

@Composable
fun PokemonStatComponent(statName: String, statValue: Int) {

    Column(Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally

    ){
        Text(
            text = statName,
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
        )
        Spacer(modifier = Modifier.height(4.dp))

        LinearProgressIndicator(
            progress = (statValue/120f),
            color = statsColorMap[statName] ?: PokemonDetailGray,
            modifier = Modifier
                .height(12.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(PokemonDetailGray)
        )

    }
}