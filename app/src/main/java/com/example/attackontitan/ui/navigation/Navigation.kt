package com.example.attackontitan.ui.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.attackontitan.ui.screens.characters.details.CharacterDetailsScreen
import com.example.attackontitan.ui.screens.characters.details.CharacterDetailsViewModel
import com.example.attackontitan.ui.screens.characters.list.CharactersListScreen
import com.example.attackontitan.ui.screens.characters.list.CharactersListViewModel
import com.example.attackontitan.ui.screens.home.HomeScreen
import com.example.attackontitan.ui.screens.locations.LocationsListScreen
import com.example.attackontitan.ui.screens.locations.LocationsListViewModel
import com.example.attackontitan.ui.screens.organizations.OrganizationsListScreen
import com.example.attackontitan.ui.screens.organizations.OrganizationsListViewModel
import com.example.attackontitan.ui.screens.titans.details.TitanDetailsScreen
import com.example.attackontitan.ui.screens.titans.list.TitanListScreen
import com.example.attackontitan.ui.screens.titans.list.TitansListViewModel

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Route.HomeScreen.route) {

        composable(route = Route.HomeScreen.route) {
            HomeScreen(navController)
        }

        composable(route = Route.TitansListScreen.route) {
            val titanViewModel = hiltViewModel<TitansListViewModel>()

            TitanListScreen(
                navController = navController,
                viewModel = titanViewModel
            )
        }

        composable(route = Route.CharactersListScreen.route) {
            val charactersViewModel = hiltViewModel<CharactersListViewModel>()

            CharactersListScreen(
                navController = navController,
                viewModel = charactersViewModel
            )
        }

        composable(
            route = Route.TitanDetailsScreen.route + "/{titanId}",
            arguments = listOf(navArgument("titanId") {
                type = NavType.IntType
            })
        ) { navBackStackEntry ->
            val itemId = navBackStackEntry.arguments?.getInt("titanId")

            itemId?.let {
                TitanDetailsScreen(titanId = it, navController = navController)
            }
        }

        composable(
            route = Route.CharacterDetailsScreen.route + "/{characterId}",
            arguments = listOf(navArgument("characterId") {
                type = NavType.IntType
            })
        ) { navBackStackEntry ->
            val characterId = navBackStackEntry.arguments?.getInt("characterId")
            val characterViewModel = hiltViewModel<CharacterDetailsViewModel>()

            characterId?.let {
                CharacterDetailsScreen(
                    viewModel = characterViewModel,
                    characterId = it
                )
            }
        }

        composable(route = Route.LocationsListScreen.route) {
            val locationsViewModel = hiltViewModel<LocationsListViewModel>()

            LocationsListScreen(viewModel = locationsViewModel)
        }

        composable(route = Route.OrganizationsListScreen.route) {
            val organizationsListViewModel = hiltViewModel<OrganizationsListViewModel>()

            OrganizationsListScreen(viewModel = organizationsListViewModel)
        }
    }
}