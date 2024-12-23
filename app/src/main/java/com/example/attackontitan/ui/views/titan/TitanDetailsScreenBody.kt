package com.example.attackontitan.ui.views.titan

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.attackontitan.data.model.characters.CharacterBaseInfo
import com.example.attackontitan.data.model.titans.TitanDetails
import com.example.attackontitan.ui.navigation.Route
import com.example.attackontitan.ui.views.details_components.ComplicatedDetailsItem
import com.example.attackontitan.ui.views.details_components.SimpleDetailsItem
import com.example.attackontitan.ui.views.details_components.TitleImageInfo
import com.example.attackontitan.utils.Resource

@Composable
fun TitanDetailsScreenBody(
    details: TitanDetails,
    characterDetails: Resource<CharacterBaseInfo>?,
    formerInheritorNames: Resource<List<CharacterBaseInfo>>?,
    navController: NavController
) {

    val inheritorName = getInheritorName(characterDetails)
    val names = getFormerInheritorNames(formerInheritorNames)

    Column(
        modifier = Modifier
            .padding(top = 8.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TitleImageInfo(name = details.name, img = details.img)

        SimpleDetailsItem(title = "current inheritor", content = inheritorName?.name) {
            navController.navigate(Route.CharacterDetailsScreen.withArgs(inheritorName?.id.toString()))
        }

        SimpleDetailsItem(title = "height", content = details.height)
        SimpleDetailsItem(title = "allegiance", content = details.allegiance)
        ComplicatedDetailsItem("former inheritors", list = names, navController = navController)
        ComplicatedDetailsItem("abilities", list = details.abilities)
    }
}

private fun getInheritorName(characterDetails: Resource<CharacterBaseInfo>?): CharacterBaseInfo? {
    return when (characterDetails) {
        is Resource.Success -> characterDetails.data
        else -> null
    }
}

private fun getFormerInheritorNames(formerInheritorNames: Resource<List<CharacterBaseInfo>>?): List<CharacterBaseInfo> {
    return when (formerInheritorNames) {
        is Resource.Success -> formerInheritorNames.data
        else -> listOf()
    }
}