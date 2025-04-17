package com.example.news_app.Domain.UseCase

import com.example.news_app.Data_layer.Networks.response.NewsModel
import com.example.news_app.Domain.repo.repo
import com.example.news_app.ResultState
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import javax.inject.Inject

class GetNewsUseCase @Inject constructor(
    private val repo : repo
) {
    suspend fun getAllNewsUseCase(category: String?): Flow<ResultState<Response<NewsModel>>> {
        return repo.getNews(category)
    }
}