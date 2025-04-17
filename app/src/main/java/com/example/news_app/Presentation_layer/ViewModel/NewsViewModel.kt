package com.example.news_app.Presentation_layer.ViewModel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.news_app.Data_layer.Networks.response.NewsModel
import com.example.news_app.Data_layer.repoImpl.repoImpl
import com.example.news_app.Domain.UseCase.GetNewsUseCase
import com.example.news_app.ResultState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val GetNewsUseCase : GetNewsUseCase
): ViewModel() {

//    private val repo = repoImpl()
//    val data = mutableStateOf<NewsModel?>(null)

   private val _getNewsState = MutableStateFlow(GetNewsState())
    val getNewsState = _getNewsState.asStateFlow()

//    init {
//        viewModelScope.launch(Dispatchers.IO) {
//            getNewsViewModel()
//        }
//    }
//
//     suspend fun getNewsViewModel() {
//        data.value = repo.getNews().body()
//    }

    fun  getNews(category: String?){
        viewModelScope.launch (Dispatchers.IO){
        GetNewsUseCase.getAllNewsUseCase(category).collectLatest {
            when(it){
                 is ResultState.Loading -> {
                    _getNewsState.value = GetNewsState(loading = true)
                }
                is ResultState.Success ->{
                    _getNewsState.value = GetNewsState(data = it.data.body())
                }
                is ResultState.Error ->{
                    _getNewsState.value = GetNewsState(error = it.message)
                }
            }
        }
        }
    }
}

data class GetNewsState(
val loading : Boolean = false,
val data : NewsModel? = null,
val error : String ?= null
)
