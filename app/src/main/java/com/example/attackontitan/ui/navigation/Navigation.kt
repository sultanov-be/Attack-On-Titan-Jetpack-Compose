package com.example.attackontitan.ui.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.attackontitan.ui.screens.CharacterScreen
import com.example.attackontitan.ui.screens.HomeScreen
import com.example.attackontitan.ui.screens.LocationScreen
import com.example.attackontitan.ui.screens.OrganizationScreen
import com.example.attackontitan.ui.screens.titans.TitanListScreen
import com.example.attackontitan.ui.screens.titans.TitanListViewModel

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.HomeScreen.route) {

        composable(route = Screen.HomeScreen.route) {
            HomeScreen(navController = navController)
        }

        composable(
            route = Screen.TitanScreen.route + "/{get}",
            arguments = listOf(
                navArgument("get") {
                    type = NavType.StringType
                    defaultValue = ""
                    nullable = true
                }
            )
        ) {
            val titanViewModel = hiltViewModel<TitanListViewModel>()
            TitanListScreen(titanViewModel)
        }
        composable(route = Screen.LocationScreen.route) {
            LocationScreen()
        }
        composable(route = Screen.OrganizationScreen.route) {
            OrganizationScreen()
        }
        composable(route = Screen.CharacterScreen.route) {
            CharacterScreen()
        }
    }
}