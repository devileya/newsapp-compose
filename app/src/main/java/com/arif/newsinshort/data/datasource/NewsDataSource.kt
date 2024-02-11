package com.arif.newsinshort.data.datasource

import com.arif.newsinshort.data.api.ApiService
import com.arif.newsinshort.data.entity.NewsResponse
import retrofit2.Response
import retrofit2.http.Query
import javax.inject.Inject

interface NewsDataSource {
    suspend fun getNewsHeadline(country: String) : Response<NewsResponse>
}

class NewsDataSourceImpl @Inject constructor(private val apiService: ApiService) : NewsDataSource {
    override suspend fun getNewsHeadline(country: String): Response<NewsResponse> {
        return apiService.getNewsHeadline(country)
    }
}