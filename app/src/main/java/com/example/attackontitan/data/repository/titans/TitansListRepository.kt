package com.example.attackontitan.data.repository.titans

import com.example.attackontitan.data.model.BaseDataModel
import com.example.attackontitan.data.model.titans.TitanDetails
import com.example.attackontitan.data.repository.DefaultListRepository
import com.example.attackontitan.data.service.TitanApiService
import com.example.attackontitan.utils.Resource
import javax.inject.Inject

interface TitansListRepository {
    suspend fun getTitansList(): Resource<List<BaseDataModel>>
    suspend fun getTitanDetails(id: Int): Resource<TitanDetails>
    suspend fun getCharacterName(id: Int): Resource<BaseDataModel>
}

class TitansListRepositoryImpl @Inject constructor(
    private val api: TitanApiService
) : TitansListRepository {
    override suspend fun getTitansList(): Resource<List<BaseDataModel>> {
        return DefaultListRepository { api.getTitansList() }.getList()
    }

    override suspend fun getTitanDetails(id: Int): Resource<TitanDetails> {
        return try {
            val response = api.getTitanById(id)
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

    override suspend fun getCharacterName(id: Int): Resource<BaseDataModel> {
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