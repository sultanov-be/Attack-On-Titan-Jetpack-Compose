package com.example.attackontitan.ui.screens.locations

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.attackontitan.ui.views.GenericLoadingView
import com.example.attackontitan.ui.views.ListItem

@Composable
fun LocationsListScreen(viewModel: LocationsListViewModel) {
    val locationPagingData = viewModel.locationsPagingData.collectAsLazyPagingItems()

    LazyColumn {
        item {
            if (locationPagingData.loadState.append is LoadState.Loading) {
                GenericLoadingView()
            }
        }

        items(locationPagingData.itemCount) {index ->
            locationPagingData[index]?.let {
                ListItem(
                    imageUrl = it.img,
                    title = it.name,
                    onClick = {}
                )
            }
        }
    }
}