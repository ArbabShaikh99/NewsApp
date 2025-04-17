package com.example.news_app.Data_layer.Service

import com.example.news_app.Data_layer.Networks.response.NewsModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    // https://newsapi.org/v2/top-headlines?country=
    // us&category=business&apiKey=e5e01a009e844e20880df490d030854d

    @GET("top-headlines")

    suspend fun getNews(
        @Query("country") country : String = "us",
        @Query("category") category : String = "business",
        @Query("apiKey") apikey : String = "e5e01a009e844e20880df490d030854d"
    ) : Response<NewsModel>

}