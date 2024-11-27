package com.example.attackontitan.data.repository.locations

import com.example.attackontitan.data.model.locations.LocationBaseInfo
import com.example.attackontitan.data.repository.BasePagingSource
import com.example.attackontitan.data.service.LocationApiService

class LocationsPagingSource(
    private val apiService: LocationApiService
) : BasePagingSource<LocationBaseInfo>(
    { page ->
        apiService.getLocations(page)
    })