package com.example.attackontitan.data.service

import com.example.attackontitan.data.model.ApiResponse
import com.example.attackontitan.data.model.characters.CharacterBaseInfo
import com.example.attackontitan.data.model.characters.CharacterDetails
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CharacterApiService {
    @GET("characters")
    suspend fun getCharacters(
        @Query("page") page: Int
    ): ApiResponse<CharacterBaseInfo>

    @GET("characters/{id}")
    suspend fun getCharacterById(@Path("id") id: Int): Response<CharacterDetails>

    @GET("characters?name={query}")
    suspend fun getCharactersFilteredByName(
        @Query("page") page: Int,
        @Query("query") query: String? = null
    ): ApiResponse<CharacterBaseInfo>
}