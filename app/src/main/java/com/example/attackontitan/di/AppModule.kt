package com.example.attackontitan.di

import com.example.attackontitan.data.repository.characters.CharacterRepository
import com.example.attackontitan.data.repository.characters.CharacterRepositoryImpl
import com.example.attackontitan.data.repository.organizations.OrganizationRepository
import com.example.attackontitan.data.repository.organizations.OrganizationRepositoryImpl
import com.example.attackontitan.data.repository.titans.TitanRepositoryImpl
import com.example.attackontitan.data.repository.locations.LocationRepository
import com.example.attackontitan.data.repository.locations.LocationRepositoryImpl
import com.example.attackontitan.data.repository.titans.TitanRepository
import com.example.attackontitan.data.service.CharacterApiService
import com.example.attackontitan.data.service.LocationApiService
import com.example.attackontitan.data.service.OrganizationApiService
import com.example.attackontitan.data.service.TitanApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    private const val BASE_URL = "https://api.attackontitanapi.com/"

    private val client = OkHttpClient.Builder().build()
    private val converter = GsonConverterFactory.create()

    private val retrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(converter)
        .baseUrl(BASE_URL)
        .client(client)
        .build()

    @Singleton
    @Provides
    fun provideTitansApi(): TitanApiService =
        retrofit.create(TitanApiService::class.java)

    @Singleton
    @Provides
    fun provideOrganizationsApi(): OrganizationApiService =
        retrofit.create(OrganizationApiService::class.java)

    @Singleton
    @Provides
    fun provideCharactersApi(): CharacterApiService =
        retrofit.create(CharacterApiService::class.java)

    @Singleton
    @Provides
    fun provideLocationsApi(): LocationApiService =
        retrofit.create(LocationApiService::class.java)

    @Singleton
    @Provides
    fun provideTitansListRepository(api: TitanApiService): TitanRepository =
        TitanRepositoryImpl(api)

    @Singleton
    @Provides
    fun provideOrganizationsListRepository(api: OrganizationApiService): OrganizationRepository =
        OrganizationRepositoryImpl(api)

    @Singleton
    @Provides
    fun provideCharactersListRepository(api: CharacterApiService) : CharacterRepository =
        CharacterRepositoryImpl(api)

    @Singleton
    @Provides
    fun provideLocationsListRepository(api: LocationApiService) : LocationRepository =
        LocationRepositoryImpl(api)
}