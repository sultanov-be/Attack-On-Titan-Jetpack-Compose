package com.example.attackontitan.data.repository.locations

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.attackontitan.data.model.locations.LocationDetails
import com.example.attackontitan.data.service.LocationApiService
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface LocationsListRepository {
    fun getLocations(): Flow<PagingData<LocationDetails>>
}

class LocationsListRepositoryImpl @Inject constructor(
    private val apiService: LocationApiService
) : LocationsListRepository {
    override fun getLocations(): Flow<PagingData<LocationDetails>> {
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