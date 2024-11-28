package com.example.attackontitan.ui.screens.characters.list

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.attackontitan.ui.navigation.Route
import com.example.attackontitan.ui.views.GenericLoadingView
import com.example.attackontitan.ui.views.ListItem
import com.example.attackontitan.ui.views.character.SearchField

@Composable
fun CharactersListScreen(viewModel: CharactersListViewModel, navController: NavHostController) {
    val characterPagingData = viewModel.charactersPagingData.collectAsLazyPagingItems()


    Column {
        SearchField(viewModel)

        LazyColumn {
            item {
                if (characterPagingData.loadState.append is LoadState.Loading) {
                    GenericLoadingView()
                }
            }

            items(characterPagingData.itemCount) { index ->
                characterPagingData[index]?.let { character ->
                    ListItem(
                        imageUrl = character.img,
                        title = character.name,
                        onClick = {
                            navController.navigate(Route.CharacterDetailsScreen.withArgs(character.id.toString()))
                        }
                    )
                }
            }
        }
    }
}