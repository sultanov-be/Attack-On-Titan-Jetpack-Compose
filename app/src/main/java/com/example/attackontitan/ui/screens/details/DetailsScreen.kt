package com.example.attackontitan.ui.screens.details

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.attackontitan.data.model.CharacterBaseInfo
import com.example.attackontitan.data.model.TitanDetails
import com.example.attackontitan.ui.views.GenericLoadingView
import com.example.attackontitan.ui.views.details_components.ComplicatedDetailsItem
import com.example.attackontitan.ui.views.details_components.SimpleDetailsItem
import com.example.attackontitan.ui.views.details_components.TitleTitanInfo
import com.example.attackontitan.utils.Resource

@Composable
fun DetailsScreen(itemId: String) {
    val detailsViewModel: DetailsViewModel = hiltViewModel()

    LaunchedEffect(itemId) {
        detailsViewModel.getTitanDetails(itemId.toInt())
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

            DetailsScreenBody(details, characterDetails, formerInheritorNames)
        }
        else -> {
            Text("Error loading details")
        }
    }
}

@Composable
fun DetailsScreenBody(
    details: TitanDetails,
    characterDetails: Resource<CharacterBaseInfo>?,
    formerInheritorNames: Resource<List<String>>?
) {

    val inheritorName = getInheritorName(characterDetails)
    val names = getFormerInheritorNames(formerInheritorNames)

    Column(
        modifier = Modifier
            .padding(top = 30.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TitleTitanInfo(name = details.name, img = details.img)
        SimpleDetailsItem(title = "height", content = details.height)
        SimpleDetailsItem(title = "current inheritor", content = inheritorName)
        SimpleDetailsItem(title = "allegiance", content = details.allegiance)
        ComplicatedDetailsItem("former inheritors", list = names)
        ComplicatedDetailsItem("abilities", list = details.abilities)
    }
}

private fun getInheritorName(characterDetails: Resource<CharacterBaseInfo>?): String {
    return when (characterDetails) {
        is Resource.Success -> characterDetails.data.name
        is Resource.Loading -> "Loading..."
        else -> "Unknown"
    }
}

private fun getFormerInheritorNames(formerInheritorNames: Resource<List<String>>?): List<String> {
    return when (formerInheritorNames) {
        is Resource.Success -> formerInheritorNames.data
        is Resource.Loading -> listOf("Loading...")
        else -> listOf("Unknown")
    }
}