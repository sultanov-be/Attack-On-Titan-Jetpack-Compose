package com.example.attackontitan.ui.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.attackontitan.ui.screens.characters.CharactersListScreen
import com.example.attackontitan.ui.screens.home.HomeScreen
import com.example.attackontitan.ui.screens.locations.LocationsListScreen
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
            TitanListScreen(titanViewModel)
        }
        composable(route = Route.LocationsListScreen.route) {
            LocationsListScreen()
        }
        composable(route = Route.OrganizationsListScreen.route) {
            val organizationsListViewModel = hiltViewModel<OrganizationsListViewModel>()
            OrganizationsListScreen(organizationsListViewModel)
        }
        composable(route = Route.CharactersListScreen.route) {
            CharactersListScreen()
        }
    }
}