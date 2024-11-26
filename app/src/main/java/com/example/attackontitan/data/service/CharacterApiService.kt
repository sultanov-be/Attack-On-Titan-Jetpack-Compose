package com.example.attackontitan.data.service

import com.example.attackontitan.data.model.ApiResponse
import com.example.attackontitan.data.model.characters.CharacterBaseInfo
import retrofit2.http.GET
import retrofit2.http.Query

interface CharacterApiService {
    @GET("characters")
    suspend fun getCharacters(
        @Query("page") page: Int
    ): ApiResponse<CharacterBaseInfo>
}