package com.example.news_app.Data_layer.repoImpl

import com.example.news_app.Data_layer.Networks.response.NewsModel
import com.example.news_app.Data_layer.Service.ApiService
import com.example.news_app.Domain.repo.repo
import com.example.news_app.ResultState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response
import javax.inject.Inject

class repoImpl @Inject constructor(
    private val apiService: ApiService
): repo{

  //  suspend fun getNewsRepo() : Response<GetNewsResponse>{
        //        return ApiProvider.provideApi().getNews()
//    }

   override suspend fun getNews(category: String?): Flow<ResultState<Response<NewsModel>>> = flow {
    emit(ResultState.Loading)

       try {
           val response = apiService.getNews(category = category ?: "general")
           emit(ResultState.Success(response))
       }catch (e: Exception) {
           emit(ResultState.Error(e.message.toString()))
       }
   }

}