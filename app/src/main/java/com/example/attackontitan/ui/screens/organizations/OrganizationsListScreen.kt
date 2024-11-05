package com.example.attackontitan.ui.screens.organizations

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.attackontitan.ui.navigation.Route
import com.example.attackontitan.ui.views.GenericListScreen
import com.example.attackontitan.ui.views.ListItem

@Composable
fun OrganizationsListScreen(
    navController: NavController,
    organizationsListViewModel: OrganizationsListViewModel
) {
    GenericListScreen(
        viewModel = organizationsListViewModel,
        itemContent = { organization ->
            ListItem(
                imageUrl = organization.img,
                title = organization.name,
                onClick = {
                    navController.navigate(Route.DetailsScreen.withArgs(organization.id.toString()))
                }
            )
        }
    )
}