package com.example.attackontitan.data.service

import com.example.attackontitan.data.model.TitanResponse
import retrofit2.http.GET

interface TitansListApiService {
    @GET("titans")
    suspend fun getTitansList(): TitanResponse
}