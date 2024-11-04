package com.example.attackontitan.ui.screens.organizations

import androidx.compose.runtime.Composable
import com.example.attackontitan.ui.views.GenericListScreen
import com.example.attackontitan.ui.views.ListItem

@Composable
fun OrganizationsListScreen(organizationsListViewModel: OrganizationsListViewModel) {
    GenericListScreen(
        viewModel = organizationsListViewModel,
        itemContent = { organization ->
            ListItem(
                imageUrl = organization.img,
                title = organization.name
            )
        }
    )
}