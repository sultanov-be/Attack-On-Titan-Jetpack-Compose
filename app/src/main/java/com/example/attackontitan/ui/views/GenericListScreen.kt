package com.example.attackontitan.ui.views

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import com.example.attackontitan.utils.BaseListViewModel
import com.example.attackontitan.utils.Resource

@Composable
fun <T> GenericListScreen(
    viewModel: BaseListViewModel<T>,
    itemContent: @Composable (T) -> Unit,
    loadingText: String = "Загрузка..."
) {
    val resource = viewModel.list.observeAsState(Resource.Loading)

    when (val state = resource.value) {
        is Resource.Loading -> {
            GenericLoadingView()
        }
        is Resource.Success -> {
            GenericGridListView(data = state.data, itemContent = itemContent)
        }
        is Resource.Error -> {
            Text("Ошибка загрузки: ${state.exception.message}")
        }
    }
}