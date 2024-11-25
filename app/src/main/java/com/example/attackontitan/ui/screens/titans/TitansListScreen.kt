package com.example.attackontitan.ui.screens.titans

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.attackontitan.ui.navigation.Route
import com.example.attackontitan.ui.views.GenericListScreen
import com.example.attackontitan.ui.views.ListItem

@Composable
fun TitanListScreen(
    navController: NavController,
    titanViewModel: TitansListViewModel
) {
    GenericListScreen(
        viewModel = titanViewModel,
        itemContent = { titan ->
            ListItem(
                imageUrl = titan.img,
                title = titan.name,
                onClick = {
                    navController.navigate(Route.DetailsScreen.withArgs(titan.id.toString()))
                }
            )
        }
    )
}