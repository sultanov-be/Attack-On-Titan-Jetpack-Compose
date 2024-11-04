package com.example.attackontitan.ui.screens.titans

import androidx.compose.runtime.Composable
import com.example.attackontitan.ui.views.GenericListScreen
import com.example.attackontitan.ui.views.ListItem

@Composable
fun TitanListScreen(titanViewModel: TitansListViewModel) {
    GenericListScreen(
        viewModel = titanViewModel,
        itemContent = { titan ->
            ListItem(
                imageUrl = titan.img,
                title = titan.name
            )
        }
    )
}