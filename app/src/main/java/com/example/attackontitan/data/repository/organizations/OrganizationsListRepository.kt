package com.example.attackontitan.data.repository.organizations

import com.example.attackontitan.data.model.BaseDataModel
import com.example.attackontitan.data.repository.DefaultListRepository
import com.example.attackontitan.data.service.OrganizationApiService
import com.example.attackontitan.utils.Resource
import javax.inject.Inject

interface OrganizationsListRepository {
    suspend fun getOrganizationsList() : Resource<List<BaseDataModel>>
}

class OrganizationsListRepositoryImpl @Inject constructor(
    private val api: OrganizationApiService
) : OrganizationsListRepository {
    override suspend fun getOrganizationsList(): Resource<List<BaseDataModel>> {
        return DefaultListRepository { api.getOrganizationsList() }.getList()
    }
}