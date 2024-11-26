package com.example.attackontitan.data.repository.locations

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.attackontitan.data.model.CharacterBaseInfo
import com.example.attackontitan.data.model.LocationBaseInfo
import com.example.attackontitan.data.repository.characters.CharactersPagingSource
import com.example.attackontitan.data.service.LocationsListApiService
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface LocationsListRepository {
    fun getLocations(): Flow<PagingData<LocationBaseInfo>>
}

class LocationsListRepositoryImpl @Inject constructor(
    val apiService: LocationsListApiService
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