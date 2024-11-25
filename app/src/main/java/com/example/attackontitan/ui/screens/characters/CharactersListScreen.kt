package com.example.attackontitan.ui.screens.characters

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.attackontitan.ui.views.GenericLoadingView
import com.example.attackontitan.ui.views.ListItem

@Composable
fun CharactersListScreen(viewModel: CharactersListViewModel) {
    val characterPagingData = viewModel.charactersPagingData.collectAsLazyPagingItems()

    LazyColumn {
        item {
            if (characterPagingData.loadState.append is LoadState.Loading) {
                GenericLoadingView()
            }
        }

        items(characterPagingData.itemCount) {index ->
            characterPagingData[index]?.let {
                ListItem(
                    imageUrl = it.img,
                    title = it.name,
                    onClick = {}
                )
            }
        }
    }
}