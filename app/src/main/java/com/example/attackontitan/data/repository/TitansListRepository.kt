package com.example.attackontitan.data.repository

import com.example.attackontitan.data.model.CharacterBaseInfo
import com.example.attackontitan.data.model.TitanBaseInfo
import com.example.attackontitan.data.model.TitanDetails
import com.example.attackontitan.data.service.TitansListApiService
import com.example.attackontitan.utils.Resource
import javax.inject.Inject

interface TitansListRepository {
    suspend fun getTitansList(): Resource<List<TitanBaseInfo>>
    suspend fun getTitanDetails(id: Int): Resource<TitanDetails>
    suspend fun getCharacterName(id: Int): Resource<CharacterBaseInfo>
}

class TitansListRepositoryImpl @Inject constructor(
    private val api: TitansListApiService
) : TitansListRepository {
    override suspend fun getTitansList(): Resource<List<TitanBaseInfo>> {
        return DefaultListRepository { api.getTitansList() }.getList()
    }

    override suspend fun getTitanDetails(id: Int): Resource<TitanDetails> {
        return try {
            val response = api.getTitanDetails(id)
            if (response.isSuccessful) {
                val titanDetails = response.body()

                if (titanDetails != null) {
                    Resource.Success(titanDetails)
                } else {
                    Resource.Error(Exception("Нет данных"))
                }
            } else {
                Resource.Error(Exception("Ошибка ${response.code()}"))
            }
        } catch (e: Exception) {
            Resource.Error(e)
        }
    }

    override suspend fun getCharacterName(id: Int): Resource<CharacterBaseInfo> {
        return try {
            val response = api.getCharacterName(id)
            if (response.isSuccessful) {
                response.body()?.let {
                    Resource.Success(it)
                } ?: Resource.Error(Exception("Empty response"))
            } else {
                Resource.Error(Exception("Failed to load character details"))
            }
        } catch (e: Exception) {
            Resource.Error(e)
        }
    }
}