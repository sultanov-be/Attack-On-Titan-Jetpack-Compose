package com.example.attackontitan.data.service

import com.example.attackontitan.data.model.TitanBaseInfo
import retrofit2.http.GET

interface ApiService {
    //TODO: Make more abstract
    @GET()
    suspend fun getTitanNames(): List<TitanBaseInfo>
}