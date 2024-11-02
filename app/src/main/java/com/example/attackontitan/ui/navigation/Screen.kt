package com.example.attackontitan.ui.navigation

sealed class Screen(val route: String) {
    object HomeScreen: Screen("home_screen")
    object TitanScreen: Screen("titan_screen")
    object CharacterScreen: Screen("character_screen")
    object OrganizationScreen: Screen("organization_screen")
    object LocationScreen: Screen("location_screen")

    fun withArgs(vararg args: String) : String =
        buildString {
            append(route)
            args.forEach {
                append("/$it")
            }
        }
}