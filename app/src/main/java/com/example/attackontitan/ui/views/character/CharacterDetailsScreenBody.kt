package com.example.attackontitan.ui.views.character

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.attackontitan.data.model.characters.CharacterDetails
import com.example.attackontitan.ui.views.details_components.ComplicatedDetailsItem
import com.example.attackontitan.ui.views.details_components.SimpleDetailsItem
import com.example.attackontitan.ui.views.details_components.TitleImageInfo

@Composable
fun CharacterDetailsScreenBody(character: CharacterDetails) {
    Column(
        modifier = Modifier
            .padding(top = 30.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        TitleImageInfo(name = character.name, img = character.img)
        SimpleDetailsItem(title = "gender", content = character.gender)
        SimpleDetailsItem(title = "age", content = formattedAge(character.age).toString())
        SimpleDetailsItem(title = "birthplace", content = character.birthplace)
        SimpleDetailsItem(title = "residence", content = character.residence)
        SimpleDetailsItem(title = "status", content = character.status)
        SimpleDetailsItem(title = "occupation", content = character.occupation)
        ComplicatedDetailsItem("alias", list = character.alias)
        ComplicatedDetailsItem("species", list = character.species)
    }
}

fun formattedAge(age: Any) = if (age == "unknown") age else age.toString().dropLast(2)