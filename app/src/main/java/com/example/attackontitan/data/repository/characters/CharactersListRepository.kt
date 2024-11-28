package com.example.attackontitan.data.repository.characters

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.attackontitan.data.model.characters.CharacterBaseInfo
import com.example.attackontitan.data.model.characters.CharacterDetails
import com.example.attackontitan.data.service.CharacterApiService
import com.example.attackontitan.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

interface CharactersListRepository {
    fun getCharacters(query: String? = null): Flow<PagingData<CharacterBaseInfo>>
    suspend fun getCharacterDetails(id: Int): Flow<Resource<CharacterDetails>>
}

class CharactersListRepositoryImpl @Inject constructor(
    private val apiService: CharacterApiService
) : CharactersListRepository {
    override fun getCharacters(query: String?): Flow<PagingData<CharacterBaseInfo>> {
        return Pager(
            config = PagingConfig(
                pageSize = 20,
                enablePlaceholders = false
            ),
            pagingSourceFactory = { CharactersPagingSource(apiService, query) }
        ).flow
    }

    override suspend fun getCharacterDetails(id: Int): Flow<Resource<CharacterDetails>> = flow {
        try {
            val response = apiService.getCharacterById(id)
            if (response.isSuccessful) {
                response.body()?.let {
                    emit(Resource.Success(it))
                } ?: emit(Resource.Error(Exception("Empty response")))
            } else {
                emit(Resource.Error(Exception("Failed to load character details")))
            }
        } catch (e: Exception) {
            emit(Resource.Error(e))
        }
    }
}