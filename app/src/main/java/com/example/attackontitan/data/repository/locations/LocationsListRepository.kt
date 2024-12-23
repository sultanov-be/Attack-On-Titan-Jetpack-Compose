package com.example.attackontitan.data.repository.locations

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.attackontitan.data.model.locations.LocationBaseInfo
import com.example.attackontitan.data.service.LocationApiService
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface LocationsListRepository {
    fun getLocations(): Flow<PagingData<LocationBaseInfo>>
}

class LocationsListRepositoryImpl @Inject constructor(
    val apiService: LocationApiService
) : LocationsListRepository {
    override fun getLocations(): Flow<PagingData<LocationBaseInfo>> {
        return Pager(
            config = PagingConfig(
                pageSize = 20,
                enablePlaceholders = false,
                prefetchDistance = 2
            ),
            pagingSourceFactory = { LocationsPagingSource(apiService) }
        ).flow
    }
}