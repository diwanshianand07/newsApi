package com.example.newsapi

data class ResponseBody(
    val articles: List<MyDataItem>,
    val status: String,
    val totalResults: Int
)