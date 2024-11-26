package com.example.attackontitan.ui.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.attackontitan.ui.screens.characters.CharactersListScreen
import com.example.attackontitan.ui.screens.characters.CharactersListViewModel
import com.example.attackontitan.ui.screens.details.DetailsScreen
import com.example.attackontitan.ui.screens.home.HomeScreen
import com.example.attackontitan.ui.screens.locations.LocationsListScreen
import com.example.attackontitan.ui.screens.locations.LocationsListViewModel
import com.example.attackontitan.ui.screens.organizations.OrganizationsListScreen
import com.example.attackontitan.ui.screens.organizations.OrganizationsListViewModel
import com.example.attackontitan.ui.screens.titans.TitanListScreen
import com.example.attackontitan.ui.screens.titans.TitansListViewModel

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Route.HomeScreen.route) {

        composable(route = Route.HomeScreen.route) {
            HomeScreen(navController = navController)
        }

        composable(
            route = Route.TitansListScreen.route,
        ) {
            val titanViewModel = hiltViewModel<TitansListViewModel>()
            TitanListScreen(
                navController = navController,
                titanViewModel = titanViewModel
            )
        }

        composable(
            route = Route.OrganizationsListScreen.route
        ) {
            val organizationsListViewModel = hiltViewModel<OrganizationsListViewModel>()
            OrganizationsListScreen(
                navController = navController,
                organizationsListViewModel = organizationsListViewModel
            )
        }

        composable(
            route = Route.DetailsScreen.route + "/{itemId}",
            arguments = listOf(navArgument("itemId") {
                type = NavType.StringType
            })
        ) { navBackStackEntry ->
            val itemId = navBackStackEntry.arguments?.getString("itemId")
            itemId?.let {
                DetailsScreen(itemId = it)
            }
        }

        composable(route = Route.LocationsListScreen.route) {
            val locationsViewModel = hiltViewModel<LocationsListViewModel>()
            LocationsListScreen(viewModel = locationsViewModel)
        }
        composable(route = Route.CharactersListScreen.route) {
            val charactersViewModel = hiltViewModel<CharactersListViewModel>()
            CharactersListScreen(viewModel = charactersViewModel)
        }
    }
}