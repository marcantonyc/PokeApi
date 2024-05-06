package com.example.pokeapi.domain.use_case

import com.example.pokeapi.common.Constants.EMPTY_STRING
import com.example.pokeapi.common.Resource
import com.example.pokeapi.data.remote.pokemon.list.asExternalModel
import com.example.pokeapi.domain.model.PokemonList
import com.example.pokeapi.domain.repository.PokemonRepository


import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetPokemonListUseCase @Inject constructor(
    private val repository: PokemonRepository
) {

    operator fun invoke(limit:String, offset: String) : Flow<Resource<PokemonList>> = flow {
        try {
            emit(Resource.Loading())

            val response = repository.getPokemons(
                limit = limit,
                offset = offset
            )

           val pokemonList = PokemonList(
               previous = response.previous?:EMPTY_STRING,
               next = response.next,
               list = response.results.mapIndexed { index, result ->  result.asExternalModel(index+1)}
           )
            emit(Resource.Success(pokemonList))
        } catch (e: HttpException){
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException){
            emit(Resource.Error("couldn't reach server. Check your internet Connection"))
        }
    }
}

