package com.example.attackontitan.data.repository

import com.example.attackontitan.data.model.OrganizationBaseInfo
import com.example.attackontitan.data.model.TitanBaseInfo
import com.example.attackontitan.data.service.OrganizationsListApiService
import com.example.attackontitan.data.service.TitansListApiService
import com.example.attackontitan.utils.Resource
import javax.inject.Inject

interface OrganizationsListRepository {
    suspend fun getOrganizationsList() : Resource<List<OrganizationBaseInfo>>
}

class OrganizationsListRepositoryImpl @Inject constructor(
    private val api: OrganizationsListApiService
) : OrganizationsListRepository {
    override suspend fun getOrganizationsList(): Resource<List<OrganizationBaseInfo>> {
        return DefaultListRepository { api.getOrganizationsList() }.getList()
    }
}