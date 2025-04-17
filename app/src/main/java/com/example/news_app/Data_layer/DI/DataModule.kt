package com.example.news_app.Data_layer.DI

import com.example.news_app.Common.BASE_URL
import com.example.news_app.Data_layer.Service.ApiService
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
object DataModule {

        @Provides
        @Singleton
        fun provideApi() :ApiService = Retrofit.Builder().baseUrl(BASE_URL)
            .client(OkHttpClient.Builder().build()).addConverterFactory(
                GsonConverterFactory.create()
            ).build().create(ApiService::class.java)

}