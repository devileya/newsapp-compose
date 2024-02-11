package com.arif.newsinshort.data.api

import com.arif.newsinshort.data.entity.NewsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("v2/top-headlines")
    suspend fun getNewsHeadline(
        @Query("country") country: String,
        @Query("apiKey") apiKey: String = "4affd1f973594e8d8bf3916b3b6ab80f"
    ) : Response<NewsResponse>
}