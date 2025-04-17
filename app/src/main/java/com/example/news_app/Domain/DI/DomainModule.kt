package com.example.news_app.Domain.DI

import com.example.news_app.Data_layer.Service.ApiService
import com.example.news_app.Data_layer.repoImpl.repoImpl
import com.example.news_app.Domain.repo.repo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DomainModule {

    @Provides
    @Singleton
    fun  provideRepo(apiservice : ApiService): repo{
        return repoImpl(apiservice)
    }
}