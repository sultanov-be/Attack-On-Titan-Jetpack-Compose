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
            if (response.results != null) {
                Resource.Success(response.results)
            } else {
                Resource.Error(Exception("No titans found"))
            }
        } catch (e: Exception) {
            Resource.Error(e)
        }
    }
}