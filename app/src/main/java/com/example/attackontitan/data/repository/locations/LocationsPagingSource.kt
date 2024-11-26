package com.example.attackontitan.data.repository.locations

import com.example.attackontitan.data.model.LocationBaseInfo
import com.example.attackontitan.data.repository.BasePagingSource
import com.example.attackontitan.data.service.LocationsListApiService

class LocationsPagingSource(
    private val apiService: LocationsListApiService
) : BasePagingSource<LocationBaseInfo>(
    { page ->
        apiService.getLocations(page)
    })