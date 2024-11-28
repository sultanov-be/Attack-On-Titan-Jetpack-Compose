package com.example.attackontitan.data.repository.locations

import com.example.attackontitan.data.model.locations.LocationDetails
import com.example.attackontitan.data.repository.BasePagingSource
import com.example.attackontitan.data.service.LocationApiService

class LocationsPagingSource(
    private val apiService: LocationApiService
) : BasePagingSource<LocationDetails>(
    { page ->
        apiService.getLocations(page)
    })