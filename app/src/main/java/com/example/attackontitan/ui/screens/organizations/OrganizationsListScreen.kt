package com.example.attackontitan.ui.screens.organizations

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
fun OrganizationsListScreen(organizationsListViewModel: OrganizationsListViewModel) {
    TitanGridListView(
        modifier = Modifier.padding(8.dp),
        viewModel = organizationsListViewModel)
}

@Composable
fun TitanGridListView(
    modifier: Modifier = Modifier,
    viewModel: OrganizationsListViewModel
) {
    val resource = viewModel.organizationsList.observeAsState(Resource.Loading)

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
                items(state.data) { organization ->
                    ListItem(
                        imageUrl = organization.img,
                        title = organization.name,
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