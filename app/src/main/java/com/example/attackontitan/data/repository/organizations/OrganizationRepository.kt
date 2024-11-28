package com.example.attackontitan.data.repository.organizations

import com.example.attackontitan.data.model.BaseDataModel
import com.example.attackontitan.data.repository.DefaultListRepositoryImpl
import com.example.attackontitan.data.service.OrganizationApiService
import com.example.attackontitan.utils.Resource
import javax.inject.Inject

interface OrganizationRepository {
    suspend fun getOrganizationsList(): Resource<List<BaseDataModel>>
}

class OrganizationRepositoryImpl @Inject constructor(
    private val api: OrganizationApiService
) : OrganizationRepository {

    override suspend fun getOrganizationsList(): Resource<List<BaseDataModel>> =
        DefaultListRepositoryImpl { api.getOrganizationsList() }.getList()

}