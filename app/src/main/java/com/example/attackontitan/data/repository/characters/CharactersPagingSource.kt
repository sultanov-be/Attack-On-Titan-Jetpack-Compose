package com.example.attackontitan.data.repository.characters

import com.example.attackontitan.data.model.characters.CharacterBaseInfo
import com.example.attackontitan.data.repository.BasePagingSource
import com.example.attackontitan.data.service.CharactersListApiService

class CharactersPagingSource(
    private val apiService: CharactersListApiService
) : BasePagingSource<CharacterBaseInfo>(
    { page ->
        apiService.getCharacters(page)
    })