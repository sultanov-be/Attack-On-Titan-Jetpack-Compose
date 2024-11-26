package com.example.attackontitan.data.service

import com.example.attackontitan.data.model.ApiResponse
import com.example.attackontitan.data.model.LocationBaseInfo
import retrofit2.http.GET
import retrofit2.http.Query

interface LocationsListApiService {
    @GET("locations")
    suspend fun getLocations(
        @Query("page")page: Int
    ): ApiResponse<LocationBaseInfo>
}