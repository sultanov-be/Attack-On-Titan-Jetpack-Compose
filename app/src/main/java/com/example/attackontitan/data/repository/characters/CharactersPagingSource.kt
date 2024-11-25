package com.example.attackontitan.data.repository.characters

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.attackontitan.data.model.CharacterBaseInfo
import com.example.attackontitan.data.service.CharacterListApiService

class CharactersPagingSource(
    private val apiService: CharacterListApiService
) : PagingSource<Int, CharacterBaseInfo>() {
    override fun getRefreshKey(state: PagingState<Int, CharacterBaseInfo>): Int? {
        TODO("Not yet implemented")
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, CharacterBaseInfo> {
        TODO("Not yet implemented")
    }
}