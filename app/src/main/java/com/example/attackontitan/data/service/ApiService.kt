package com.example.attackontitan.data.service

import com.example.attackontitan.data.model.TitanResponse
import retrofit2.http.GET

interface ApiService {
    //TODO: Make more abstract
    @GET("titans")
    suspend fun getTitanNames(): TitanResponse
}