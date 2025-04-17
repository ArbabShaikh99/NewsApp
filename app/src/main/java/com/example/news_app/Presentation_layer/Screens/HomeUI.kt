package com.example.news_app.Presentation_layer.Screens


import android.os.Build
import android.text.format.DateUtils
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.AlertDialogDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import coil.compose.SubcomposeAsyncImage
import com.example.news_app.Presentation_layer.ViewModel.NewsViewModel
import com.example.news_app.ui.theme.DarkPink
import com.example.news_app.ui.theme.MediumPink
import java.time.Instant



@Composable
fun HomeUI(newsviewModel: NewsViewModel = hiltViewModel()) {

     val getNewsResponse = newsviewModel.getNewsState.collectAsState()


    LaunchedEffect(Unit) {
        newsviewModel.getNews("general")
    }

    val getAllNewsResponse = getNewsResponse.value.data?.articles ?: emptyList()
    Log.d("data", " Show Items  : ${getAllNewsResponse.toString()}")

    when {
        getNewsResponse.value.loading -> {
           // Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
//                CircularProgressIndicator(color = Color.Blue, modifier = Modifier.size(45.dp))
//            }
            Column {
                repeat(10) {
                    AnimatedShimmer()
                }
            }
        }

        getNewsResponse.value.error != null -> {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text("Error: ${getNewsResponse.value.error}")
            }
        }

        else -> {
            LazyColumn {
                items(getAllNewsResponse) { article ->
                    eachCard(
                        title = article.title,
                        url = article.urlToImage,
                        description = article.description,
                        content = article.content,
                        articleUrl = article.url,
                        date = article.publishedAt
                    )
                }
            }
        }
    }


}

//@Composable
//fun cardItem(
//    Title:String,Description:String,UrlToImage:String) {
//
//    Card(modifier = Modifier.fillMaxWidth().padding(8.dp)) {
//
//        Row(
//            modifier = Modifier
//                .fillMaxSize()
//                .padding(8.dp)
//                .height(100.dp), verticalAlignment = Alignment.CenterVertically
//        ) {
//
//            SubcomposeAsyncImage(
//                model = UrlToImage,
//                loading = {
//                    CircularProgressIndicator()
//                },
//                contentDescription = ""
//            )
//            Column {
//                Text(Title)
//                Text(Description)
//            }
//        }
//    }
//}

@Composable
fun eachCard(
    title: String,
    url: String?,
    description: String?,
    content: String?,
    articleUrl: String?,
    date: String? = null
) {
    var showDialog by remember { mutableStateOf(false) }
    val urlHandler = LocalUriHandler.current



    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { showDialog = true }
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .background(MediumPink)
                .height(100.dp)
                .padding(8.dp)
        ) {
            if (url != null) {
                SubcomposeAsyncImage(
                    model = url,
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(80.dp)
                        .clip(RoundedCornerShape(8.dp)),
                    loading = {
                        imageani()
                    },
                    error = {
                        Text(text = "Error loading image")
                    }
                )
            }
                Spacer(modifier = Modifier.width(8.dp))

                Column {
                    Text(
                        text = title,
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    date?.let {
                        //  TimeAgo(timestamp = it)
                    }
                }
            }
        }


    if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false },
            confirmButton = {
                TextButton(onClick = { showDialog = false }) {
                    Text("OK")
                }
            },
            dismissButton = {
                TextButton(onClick = {


                    urlHandler.openUri(articleUrl!!)

                }) {
                    Text("Read More")
                }
            },
            title = {
                Text(
                    text = title,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                )
            },
            text = {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .verticalScroll(rememberScrollState()),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    if (url != null) {

                        AsyncImage(
                            model = url,
                            contentScale = ContentScale.Crop,
                            contentDescription = null,
                            modifier = Modifier.size(200.dp).clip(RoundedCornerShape(10.dp))
                        )

                    }

                    if (description != null) {
                        Text(
                            text = "Description:",
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp,
                            textAlign = TextAlign.Center
                        )
                        Text(
                            text = description,
                            fontSize = 14.sp,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.padding(bottom = 8.dp)
                        )
                    }

                    if (content != null) {
                        Text(
                            text = "Content:",
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp,
                            textAlign = TextAlign.Center
                        )
                        Text(
                            text = content,
                            fontSize = 14.sp,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.padding(bottom = 8.dp)
                        )
                    }
                }
            }, containerColor = Color(0xFFFFF0F0)

        )

    }
}

// this is for time ago , because we are gatting row time from srver we can't use it
//@RequiresApi(Build.VERSION_CODES.O)
//@Composable
//fun TimeAgo(timestamp: String) {
//    val timeAgo = remember(timestamp) {
//        val instant = Instant.parse(timestamp)
//        val now = System.currentTimeMillis()
//        val time = instant.toEpochMilli()
//        val relativeTime = DateUtils.getRelativeTimeSpanString(
//            time,
//            now,
//            DateUtils.MINUTE_IN_MILLIS,
//            DateUtils.FORMAT_ABBREV_RELATIVE
//        ).toString()
//        relativeTime
//
//    }
//
//    Text(
//        text = timeAgo,
//        style = TextStyle(
//            fontSize = 12.sp,
//            fontWeight = FontWeight.Normal,
//
//            color = MaterialTheme.colorScheme.secondary,
//
//            ),
//    )
//}

