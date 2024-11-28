package com.example.attackontitan.data.repository.characters

import com.example.attackontitan.data.model.characters.CharacterBaseInfo
import com.example.attackontitan.data.repository.BasePagingSource
import com.example.attackontitan.data.service.CharacterApiService

//(TODO: Maybe edited later)
class CharactersPagingSource(
    private val apiService: CharacterApiService,
    private val query: String? = null
) : BasePagingSource<CharacterBaseInfo>(
    { page ->
            apiService.getCharacters(page, query)
    })