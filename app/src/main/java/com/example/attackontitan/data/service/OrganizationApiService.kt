package com.example.attackontitan.data.service

import com.example.attackontitan.data.model.ApiResponse
import com.example.attackontitan.data.model.organizations.OrganizationBaseInfo
import retrofit2.http.GET

interface OrganizationApiService {
    @GET("organizations")
    suspend fun getOrganizationsList(): ApiResponse<OrganizationBaseInfo>
}