package com.example.news_app.Data_layer.Networks.response

data class NewsModel(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)