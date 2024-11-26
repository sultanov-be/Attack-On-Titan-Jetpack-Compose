package com.example.attackontitan.data.repository.characters

import com.example.attackontitan.data.model.characters.CharacterBaseInfo
import com.example.attackontitan.data.repository.BasePagingSource
import com.example.attackontitan.data.service.CharacterApiService

class CharactersPagingSource(
    private val apiService: CharacterApiService
) : BasePagingSource<CharacterBaseInfo>(
    { page ->
        apiService.getCharacters(page)
    })