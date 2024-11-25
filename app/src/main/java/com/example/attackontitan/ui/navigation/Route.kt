package com.example.attackontitan.ui.navigation

sealed class Route(val route: String) {
    data object HomeScreen: Route("home_screen")
    data object TitansListScreen: Route("titans_list_screen")
    data object CharactersListScreen: Route("characters_list_screen")
    data object OrganizationsListScreen: Route("organizations_list_screen")
    data object LocationsListScreen: Route("locations_list_screen")
    data object DetailsScreen: Route("details_screen")

    fun withArgs(vararg args: String) : String =
        buildString {
            append(route)
            args.forEach {
                append("/$it")
            }
        }
}