package com.example.attackontitan.data.repository

import com.example.attackontitan.data.model.OrganizationBaseInfo
import com.example.attackontitan.data.service.OrganizationsListApiService
import com.example.attackontitan.utils.Resource
import javax.inject.Inject

class OrganizationsListRepository @Inject constructor(
    private val api : OrganizationsListApiService
) {
    suspend fun getOrganizationsList(): Resource<List<OrganizationBaseInfo>> {
        return try {
            val response = api.getOrganizationsList()
            Resource.Success(response.results)
        } catch (e: Exception) {
            Resource.Error(e)
        }
    }
}