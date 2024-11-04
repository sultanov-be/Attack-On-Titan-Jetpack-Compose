package com.example.attackontitan.data.repository

import com.example.attackontitan.data.model.TitanBaseInfo
import com.example.attackontitan.data.service.TitansListApiService
import com.example.attackontitan.utils.Resource
import javax.inject.Inject

class TitansListRepository @Inject constructor(
    private val api : TitansListApiService
) {
    suspend fun getTitansList(): Resource<List<TitanBaseInfo>> {
        return try {
            val response = api.getTitansList()
            Resource.Success(response.results)
        } catch (e: Exception) {
            Resource.Error(e)
        }
    }
}