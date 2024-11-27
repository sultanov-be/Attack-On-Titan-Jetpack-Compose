package com.example.attackontitan.ui.screens.titans.details

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.attackontitan.ui.views.GenericLoadingView
import com.example.attackontitan.ui.views.titan.TitanDetailsScreenBody
import com.example.attackontitan.utils.Resource

@Composable
fun TitanDetailsScreen(titanId: Int, navController: NavHostController) {
    val detailsViewModel: TitanDetailsViewModel = hiltViewModel()

    LaunchedEffect(titanId) {
        detailsViewModel.getTitanDetails(titanId)
    }

    val titanDetails by detailsViewModel.titanDetails.observeAsState()
    val characterDetails by detailsViewModel.characterDetails.observeAsState()
    val formerInheritorNames by detailsViewModel.formerInheritorNames.observeAsState()

    when (titanDetails) {
        is Resource.Loading -> {
            GenericLoadingView()
        }
        is Resource.Success -> {
            val details = (titanDetails as Resource.Success).data

            LaunchedEffect(titanDetails) {
                detailsViewModel.getCharacterName(details.current_inheritor)
                detailsViewModel.getFormerInheritorNames(details.former_inheritors)
            }

            TitanDetailsScreenBody(
                details = details,
                characterDetails = characterDetails,
                formerInheritorNames = formerInheritorNames,
                navController = navController)
        }
        else -> {
            Text("Error loading details")
        }
    }
}