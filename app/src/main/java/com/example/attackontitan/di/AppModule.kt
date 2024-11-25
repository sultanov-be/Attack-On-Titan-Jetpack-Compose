package com.example.attackontitan.di

import com.example.attackontitan.data.repository.OrganizationsListRepository
import com.example.attackontitan.data.repository.OrganizationsListRepositoryImpl
import com.example.attackontitan.data.repository.TitansListRepository
import com.example.attackontitan.data.repository.TitansListRepositoryImpl
import com.example.attackontitan.data.repository.characters.CharactersListRepository
import com.example.attackontitan.data.repository.characters.CharactersListRepositoryImpl
import com.example.attackontitan.data.service.CharactersListApiService
import com.example.attackontitan.data.service.OrganizationsListApiService
import com.example.attackontitan.data.service.TitansListApiService
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
    fun provideTitansApi(): TitansListApiService =
        retrofit.create(TitansListApiService::class.java)

    @Singleton
    @Provides
    fun provideOrganizationsApi(): OrganizationsListApiService =
        retrofit.create(OrganizationsListApiService::class.java)

    @Singleton
    @Provides
    fun provideCharactersApi(): CharactersListApiService =
        retrofit.create(CharactersListApiService::class.java)


    @Singleton
    @Provides
    fun provideTitansListRepository(api: TitansListApiService): TitansListRepository =
        TitansListRepositoryImpl(api)

    @Singleton
    @Provides
    fun provideOrganizationsListRepository(api: OrganizationsListApiService): OrganizationsListRepository =
        OrganizationsListRepositoryImpl(api)

    @Singleton
    @Provides
    fun provideCharactersListRepository(api: CharactersListApiService) : CharactersListRepository =
        CharactersListRepositoryImpl(api)
}