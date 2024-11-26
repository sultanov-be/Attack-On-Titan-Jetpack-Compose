package com.example.attackontitan.ui.views.titan

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.attackontitan.data.model.characters.CharacterBaseInfo
import com.example.attackontitan.data.model.titans.TitanDetails
import com.example.attackontitan.ui.views.details_components.ComplicatedDetailsItem
import com.example.attackontitan.ui.views.details_components.SimpleDetailsItem
import com.example.attackontitan.ui.views.details_components.TitleTitanInfo
import com.example.attackontitan.utils.Resource

@Composable
fun TitanDetailsScreenBody(
    details: TitanDetails,
    characterDetails: Resource<CharacterBaseInfo>?,
    formerInheritorNames: Resource<List<String>>?
) {

    val inheritorName = getInheritorName(characterDetails)
    val names = getFormerInheritorNames(formerInheritorNames)

    Column(
        modifier = Modifier
            .padding(top = 8.dp)
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