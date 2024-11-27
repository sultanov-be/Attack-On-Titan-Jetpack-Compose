package com.example.attackontitan.data.repository

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.attackontitan.data.model.ApiResponse

open class BasePagingSource<T : Any>(
    private val apiCall: suspend (page: Int) -> ApiResponse<T>
) : PagingSource<Int, T>() {

    override fun getRefreshKey(state: PagingState<Int, T>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, T> {
        val page = params.key ?: 1

        return try {
            val response = apiCall(page)

            LoadResult.Page(
                data = response.results,
                prevKey = if (page > 1) page - 1 else null,
                nextKey = if (response.info.next_page != null) page + 1 else null
            )
        } catch (e: Exception) {
            val errorMessage = "Error in ${this::class.simpleName}: ${e.localizedMessage}"
            Log.e(this::class.simpleName, errorMessage, e)
            LoadResult.Error(e)
        }
    }
}