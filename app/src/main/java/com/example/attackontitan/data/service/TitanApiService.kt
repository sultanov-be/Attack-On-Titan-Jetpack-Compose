package com.example.attackontitan.data.service

import com.example.attackontitan.data.model.ApiResponse
import com.example.attackontitan.data.model.BaseDataModel
import com.example.attackontitan.data.model.titans.TitanDetails
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface TitanApiService {
    @GET("titans")
    suspend fun getTitansList(): ApiResponse<BaseDataModel>

    @GET("titans/{id}")
    suspend fun getTitanById(@Path("id") id: Int) : Response<TitanDetails>

    @GET("characters/{id}")
    suspend fun getCharacterName(@Path("id") id: Int) : Response<BaseDataModel>
}