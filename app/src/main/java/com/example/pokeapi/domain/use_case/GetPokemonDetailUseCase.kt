package com.example.pokeapi.domain.use_case

import com.example.pokeapi.common.Resource
import com.example.pokeapi.data.remote.pokemon.detail.asExternalModel
import com.example.pokeapi.domain.model.PokemonDetail
import com.example.pokeapi.domain.repository.PokemonRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetPokemonDetailUseCase @Inject constructor(
    private val repository: PokemonRepository
)
{
    operator fun invoke(name: String) : Flow<Resource<PokemonDetail>> = flow {
        try {

            emit(Resource.Loading())
            val response = repository.getPokemonDetail(
                name= name
            )
            emit(Resource.Success(response.asExternalModel()))

        } catch (e: HttpException){
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException){
            emit(Resource.Error("couldn't reach server. Check your internet Connection"))
        }
    }
}
