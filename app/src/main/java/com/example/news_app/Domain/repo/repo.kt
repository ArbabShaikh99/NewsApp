package com.example.news_app.Domain.repo

import com.example.news_app.Data_layer.Networks.response.NewsModel
import com.example.news_app.ResultState
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface repo {

    suspend fun getNews(category: String?): Flow<ResultState<Response<NewsModel>>>
}