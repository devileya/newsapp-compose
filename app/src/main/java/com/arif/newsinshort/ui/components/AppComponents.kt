package com.arif.newsinshort.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.arif.newsinshort.R
import com.arif.newsinshort.data.entity.Article
import com.arif.newsinshort.data.entity.NewsResponse
import com.arif.newsinshort.ui.theme.Purple40

@Composable
fun Loader() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        CircularProgressIndicator(
            modifier = Modifier
                .size(60.dp)
                .padding(10.dp),
            color = Purple40
        )
    }
}


@Composable
fun NewsList(response: NewsResponse) {
    LazyColumn {
        items(response.articles) {
            NormalTextComponent(textValue = it.title ?: "NA")
        }
    }
}

@Composable
fun NormalTextComponent(textValue: String) {
    Text(
        text = textValue, modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(8.dp),
        style = TextStyle(
            fontSize = 18.sp,
            fontWeight = FontWeight.Normal,
            fontFamily = FontFamily.Monospace,
            color = Purple40
        )
    )
}

@Composable
fun AuthorDetailsComponent(authorName: String?, sourceName: String?) {
    Row(modifier = Modifier.fillMaxWidth().padding(start = 10.dp, end = 10.dp)) {
        authorName?.also { NormalTextComponent(textValue = it) }
        sourceName?.also { NormalTextComponent(textValue = it) }
    }
}

@Composable
fun HeadingTextComponent(textValue: String) {
    Text(
        text = textValue, modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(8.dp),
        style = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.Medium)
    )
}

@Composable
fun NewsRowComponent(page: Int, article: Article) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
            .background(Color.White)
    ) {
        AsyncImage(
            model = article.urlToImage, contentDescription = "",
            modifier = Modifier
                .fillMaxWidth()
                .height(240.dp)
                .wrapContentHeight(),
            contentScale = ContentScale.Fit,
            placeholder = painterResource(id = R.drawable.ic_launcher_foreground),
            error = painterResource(id = R.drawable.ic_launcher_background)
        )

        Spacer(modifier = Modifier.size(20.dp))

        HeadingTextComponent(textValue = article.title ?: "NA")

        Spacer(modifier = Modifier.size(10.dp))

        NormalTextComponent(textValue = article.description ?: "")

        Spacer(modifier = Modifier.size(10.dp))

        AuthorDetailsComponent(authorName = article.author, sourceName = article.source?.name)
    }
}

@Preview
@Composable
fun NewsRowComponentPreview() {
    NewsRowComponent(0, Article(author = "Mr. X", title = "Lorem Ipsum"))
}