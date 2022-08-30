package com.example.newsapi

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("top-headlines?sources=techcrunch&apiKey=5f00e07fdb97460b954203895873d9e2")
    fun getData() : Call<ResponseBody>
}