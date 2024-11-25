package com.example.attackontitan.data.repository.characters

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.attackontitan.data.model.CharacterBaseInfo
import com.example.attackontitan.data.service.CharactersListApiService

class CharactersPagingSource(
    private val apiService: CharactersListApiService
) : PagingSource<Int, CharacterBaseInfo>() {

    override fun getRefreshKey(state: PagingState<Int, CharacterBaseInfo>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, CharacterBaseInfo> {
        val page = params.key ?: 1
        return try {
            val response = apiService.getCharacters(page)

            LoadResult.Page(
                data = response.results, // results — это List<CharacterBaseInfo>
                prevKey = if (page > 1) page - 1 else null,
                nextKey = if (response.info.next_page != null) page + 1 else null
            )
        } catch (e: Exception) {
            Log.e("CharactersPagingSource", "Error loading data", e)
            LoadResult.Error(e)
        }
    }
}