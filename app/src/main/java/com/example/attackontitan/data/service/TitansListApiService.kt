package com.example.attackontitan.data.service

import com.example.attackontitan.data.model.ApiResponse
import com.example.attackontitan.data.model.TitanBaseInfo
import com.example.attackontitan.data.model.TitanDetails
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface TitansListApiService {
    @GET("titans")
    suspend fun getTitansList(): ApiResponse<TitanBaseInfo>

    @GET("titans/{id}")
    suspend fun getTitanDetails(@Path("id") id: Int) : Response<TitanDetails>
}