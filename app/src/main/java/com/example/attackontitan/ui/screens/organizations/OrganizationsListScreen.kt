package com.example.attackontitan.ui.screens.organizations

import androidx.compose.runtime.Composable
import com.example.attackontitan.ui.views.GenericListScreen
import com.example.attackontitan.ui.views.ListItem

@Composable
fun OrganizationsListScreen(organizationsListViewModel: OrganizationsListViewModel) {
    GenericListScreen(
        viewModel = organizationsListViewModel,
        itemContent = { titan ->
            ListItem(
                imageUrl = titan.img,
                title = titan.name
            )
        }
    )
}