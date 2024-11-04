package com.example.attackontitan.di

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

private const val BASE_URL = "https://api.attackontitanapi.com/"

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideTitansApi(): TitansListApiService = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(OkHttpClient.Builder().build())
        .build()
        .create(TitansListApiService::class.java)

    @Singleton
    @Provides
    fun provideOrganizationsApi(): OrganizationsListApiService = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(OkHttpClient.Builder().build())
        .build()
        .create(OrganizationsListApiService::class.java)
}