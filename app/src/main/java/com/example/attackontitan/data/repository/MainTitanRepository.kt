package com.example.attackontitan.data.repository

import com.example.attackontitan.data.model.TitanBaseInfo
import com.example.attackontitan.data.service.ApiService
import javax.inject.Inject

class MainTitanRepository @Inject constructor(
    private val api : ApiService
) {
  suspend fun getBaseTitanInfo(): List<TitanBaseInfo> {
      return api.getTitanNames()
  }
}