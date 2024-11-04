package com.example.attackontitan.data.service

import com.example.attackontitan.data.model.ApiResponse
import com.example.attackontitan.data.model.OrganizationBaseInfo
import retrofit2.http.GET

interface OrganizationsListApiService {
    @GET("organizations")
    suspend fun getOrganizationsList(): ApiResponse<OrganizationBaseInfo>
}