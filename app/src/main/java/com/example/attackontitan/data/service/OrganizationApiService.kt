package com.example.attackontitan.data.service

import com.example.attackontitan.data.model.ApiResponse
import com.example.attackontitan.data.model.BaseDataModel
import retrofit2.http.GET

interface OrganizationApiService {
    @GET("organizations")
    suspend fun getOrganizationsList(): ApiResponse<BaseDataModel>
}