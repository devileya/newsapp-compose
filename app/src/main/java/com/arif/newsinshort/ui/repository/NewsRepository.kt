package com.arif.newsinshort.ui.repository

import com.arif.newsinshort.data.datasource.NewsDataSource
import com.arif.newsinshort.data.entity.NewsResponse
import com.arif.utilities.ResourceState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import retrofit2.Response
import javax.inject.Inject

class NewsRepository @Inject constructor(private val newsDataSource: NewsDataSource) {
    suspend fun getNewsHeadline(country: String): Flow<ResourceState<NewsResponse>> = flow {
        emit(ResourceState.Loading())
        val response = newsDataSource.getNewsHeadline(country)
        if (response.isSuccessful && response.body() != null) {
            emit(ResourceState.Success(response.body()!!))
        } else {
            emit(ResourceState.Error("Error fetching news data"))
        }
    }.catch { e ->
        emit(ResourceState.Error(e.message ?: "Error in flow"))
    }
}
