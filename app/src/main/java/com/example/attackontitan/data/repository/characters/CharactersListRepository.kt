package com.example.attackontitan.data.repository.characters

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.attackontitan.data.model.characters.CharacterBaseInfo
import com.example.attackontitan.data.service.CharacterApiService
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface CharactersListRepository {
    fun getCharacters(): Flow<PagingData<CharacterBaseInfo>>
}

class CharactersListRepositoryImpl @Inject constructor(
    private val apiService: CharacterApiService
) : CharactersListRepository {
    override fun getCharacters(): Flow<PagingData<CharacterBaseInfo>> {
        return Pager(
            config = PagingConfig(
                pageSize = 20,
                enablePlaceholders = false,
                prefetchDistance = 2
            ),
            pagingSourceFactory = { CharactersPagingSource(apiService) }
        ).flow
    }
}