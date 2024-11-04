package com.example.attackontitan.data.service

import com.example.attackontitan.data.model.ApiResponse
import com.example.attackontitan.data.model.TitanBaseInfo
import retrofit2.http.GET

interface TitansListApiService {
    @GET("titans")
    suspend fun getTitansList(): ApiResponse<TitanBaseInfo>
}