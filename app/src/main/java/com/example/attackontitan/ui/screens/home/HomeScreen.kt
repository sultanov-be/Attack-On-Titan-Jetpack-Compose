package com.example.attackontitan.ui.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.attackontitan.R
import com.example.attackontitan.ui.navigation.Route
import com.example.attackontitan.ui.views.home.MainGridItem

@Composable
fun HomeScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        HomeScreenGrid(
            navController = navController,
            modifier = Modifier.fillMaxWidth().weight(1f)
        )
    }
}

@Composable
fun HomeScreenGrid(navController: NavController, modifier: Modifier) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        MainGridItem(
            modifier = Modifier.weight(1f),
            text = "Titans",
            img = painterResource(R.drawable.img_titans),
            onClick = { navController.navigate(Route.TitansListScreen.route) }
        )
        MainGridItem(
            modifier = Modifier.weight(1f),
            text = "Locations",
            img = painterResource(R.drawable.img_locations),
            onClick = { navController.navigate(Route.LocationsListScreen.route) }
        )
    }
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {

        MainGridItem(
            modifier = Modifier.weight(1f),
            text = "Characters",
            img = painterResource(R.drawable.img_characters),
            onClick = { navController.navigate(Route.CharactersListScreen.route) }
        )

        MainGridItem(
            modifier = Modifier.weight(1f),
            text = "Organizations",
            img = painterResource(R.drawable.img_characters),
            onClick = { navController.navigate(Route.OrganizationsListScreen.route) }
        )
    }
}