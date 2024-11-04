package com.example.attackontitan.data.repository

import com.example.attackontitan.data.model.TitanBaseInfo
import com.example.attackontitan.data.service.TitansListApiService
import com.example.attackontitan.utils.Resource
import javax.inject.Inject

interface TitansListRepository {
    suspend fun getTitansList() : Resource<List<TitanBaseInfo>>
}

class TitansListRepositoryImpl @Inject constructor(
    private val api: TitansListApiService
) : TitansListRepository {
    override suspend fun getTitansList(): Resource<List<TitanBaseInfo>> {
        return DefaultListRepository { api.getTitansList() }.getList()
    }
}