package com.example.attackontitan.data.repository

import com.example.attackontitan.data.model.ApiResponse
import com.example.attackontitan.utils.Resource
import javax.inject.Inject

interface DefaultListRepository<T> {
    suspend fun getList(): Resource<List<T>>
}

class DefaultListRepositoryImpl<T> @Inject constructor(
    private val apiCall: suspend () -> ApiResponse<T>
) : DefaultListRepository<T> {
    override suspend fun getList(): Resource<List<T>> {
        return try {
            val response = apiCall()
            Resource.Success(response.results)
        } catch (e: Exception) {
            Resource.Error(e)
        }
    }
}