package com.arif.newsinshort.ui.screens

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.arif.newsinshort.data.entity.Article
import com.arif.newsinshort.data.entity.NewsResponse
import com.arif.newsinshort.ui.components.Loader
import com.arif.newsinshort.ui.components.NewsRowComponent
import com.arif.newsinshort.ui.viewmodel.NewsViewModel
import com.arif.utilities.ResourceState

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(
    newsViewModel: NewsViewModel = hiltViewModel()
) {
    val newsResponse = newsViewModel.news.collectAsState().value
    val pagerState = rememberPagerState(initialPage = 0, initialPageOffsetFraction = 0f){
        100
    }
    VerticalPager(
        state = pagerState, 
        modifier = Modifier.fillMaxSize(),
        pageSize = PageSize.Fill,
        pageSpacing = 8.dp
    ) { page ->
        when (newsResponse) {
            is ResourceState.Loading -> {
                Log.d("HomeScreen", "Loading")
                Loader()
            }

            is ResourceState.Success -> {
                val response = newsResponse.data
                if (response.articles.isNotEmpty()) {
                    NewsRowComponent(page, response.articles[page])
                }
                Log.d("HomeScreen", "Success ${response.status} = ${response.totalResults}")
            }

            is ResourceState.Error -> {
                Log.d("HomeScreen", "Error ${newsResponse.message}")
            }
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}