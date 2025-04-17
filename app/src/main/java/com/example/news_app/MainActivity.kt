package com.example.news_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.news_app.Presentation_layer.ViewModel.NewsViewModel
import com.example.news_app.Presentation_layer.Screens.HomeUI
import com.example.news_app.Presentation_layer.Screens.ModalDrawerScreen
import com.example.news_app.ui.theme.News_AppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val viewModel : NewsViewModel by viewModels()
        setContent {
            News_AppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ModalDrawerScreen()
                }
            }
        }
    }
}

