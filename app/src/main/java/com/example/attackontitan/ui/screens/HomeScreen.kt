package com.example.attackontitan.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.attackontitan.ui.navigation.Screen

@Composable
fun HomeScreen(navController: NavController) {
    Column {
        Button(
            onClick = {
                navController.navigate(Screen.TitanScreen.withArgs("titans"))
            },
            modifier = Modifier.padding(8.dp)
        ) {
            Text("Titan Screen")
        }

        Button(
            onClick = {
                navController.navigate(Screen.OrganizationScreen.route)
            },
            modifier = Modifier.padding(8.dp)
        ) {
            Text("Organization Screen")
        }

        Button(
            onClick = {
                navController.navigate(Screen.LocationScreen.route)
            },
            modifier = Modifier.padding(8.dp)
        ) {
            Text("Location Screen")
        }

        Button(
            onClick = {
                navController.navigate(Screen.CharacterScreen.route)
            },
            modifier = Modifier.padding(8.dp)
        ) {
            Text("Character Screen")
        }
    }
}