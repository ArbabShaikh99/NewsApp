package com.example.news_app.Presentation_layer.Screens

import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.news_app.Presentation_layer.ViewModel.NewsViewModel
import com.example.news_app.ui.theme.DarkPink
import com.example.news_app.ui.theme.LightPink

@Composable
fun NewsTabs(viewModel: NewsViewModel) {
    val tabs = listOf("General", "Tech", "Sports" , "Business" , "Entertainment" , "Science")
    var selectedTabIndex by remember { mutableStateOf(0) }

    ScrollableTabRow(selectedTabIndex = selectedTabIndex,
        //modifier = Modifier.fillMaxWidth().horizontalScroll(rememberScrollState()),
        edgePadding = 16.dp,
        containerColor = LightPink,
        // indicator color define here----
        indicator = { tabPositions ->
            TabRowDefaults.Indicator(
                modifier = Modifier.tabIndicatorOffset(tabPositions[selectedTabIndex]),
                color = DarkPink,
                height = 3.dp
            )
        }

        ) {

        tabs.forEachIndexed { index, title ->
            Tab(
                selected = selectedTabIndex == index,
                onClick = {
                    selectedTabIndex = index
                    val category = when (title) {
                        "Tech" -> "technology"
                        "Sports" -> "sports"
                        "Business" -> "business"
                        "Entertainment" -> "entertainment"
                        "Science" -> "science"
                        else -> null
                    }
                    viewModel.getNews(category)
                },
                selectedContentColor = DarkPink,
                unselectedContentColor = Color.Gray,
                text = { Text(title) }
            )

        }
    }
}
