package com.example.attackontitan.data.repository.locations

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.attackontitan.data.model.LocationBaseInfo
import com.example.attackontitan.data.service.LocationsListApiService

class LocationsPagingSource(
    private val apiService: LocationsListApiService
) : PagingSource<Int, LocationBaseInfo>() {

    override fun getRefreshKey(state: PagingState<Int, LocationBaseInfo>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, LocationBaseInfo> {
        val page = params.key ?: 1
        return try {
            val response = apiService.getLocations(page)

            LoadResult.Page(
                data = response.results,
                prevKey = if (page > 1) page - 1 else null,
                nextKey = if (response.info.next_page != null) page + 1 else null
            )
        } catch (e: Exception) {
            Log.e("LocationPagingSource", "Error loading data", e)
            LoadResult.Error(e)
        }
    }
}