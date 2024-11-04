package com.example.attackontitan.ui.screens.titans

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.attackontitan.ui.views.ListItem
import com.example.attackontitan.utils.Resource

@Composable
fun TitanListScreen(titanViewModel: TitansListViewModel) {
    TitanGridListView(viewModel = titanViewModel)
}

@Composable
fun TitanGridListView(
    modifier: Modifier = Modifier,
    viewModel: TitansListViewModel
) {
    val resource = viewModel.titanList.observeAsState(Resource.Loading)

    when (val state = resource.value) {
        is Resource.Loading -> {
            CircularProgressIndicator()
            Text("Загрузка титанов...")
        }

        is Resource.Success -> {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = modifier
            ) {
                items(state.data) { titan ->
                    ListItem(
                        imageUrl = titan.img,
                        title = titan.name,
                        modifier = Modifier.padding(8.dp)
                    )
                }
            }
        }

        is Resource.Error -> {
            Text("Ошибка загрузки титанов: ${state.exception.message}")
        }
    }
}