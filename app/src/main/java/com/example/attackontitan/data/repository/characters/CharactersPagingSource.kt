package com.example.attackontitan.data.repository.characters

import com.example.attackontitan.data.model.BaseDataModel
import com.example.attackontitan.data.repository.BasePagingSource
import com.example.attackontitan.data.service.CharacterApiService

class CharactersPagingSource(
    private val apiService: CharacterApiService,
    private val query: String? = null
) : BasePagingSource<BaseDataModel>(
    { page ->
            apiService.getCharacters(page, query)
    })