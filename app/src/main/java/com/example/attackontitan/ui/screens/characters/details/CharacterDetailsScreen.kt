package com.example.attackontitan.ui.screens.characters.details

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.example.attackontitan.ui.views.GenericLoadingView
import com.example.attackontitan.ui.views.SampleScreen
import com.example.attackontitan.ui.views.character.CharacterDetailsScreenBody
import com.example.attackontitan.utils.Resource

@Composable
fun CharacterDetailsScreen(viewModel: CharacterDetailsViewModel, characterId: Int) {
    val characterDetailsState by viewModel.characterDetails.collectAsState()

    LaunchedEffect(characterId) {
        viewModel.loadCharacterDetails(characterId)
    }

    when (val state = characterDetailsState) {
        is Resource.Loading -> {
            GenericLoadingView()
        }
        is Resource.Success -> {
            CharacterDetailsScreenBody(character = state.data)
        }
        is Resource.Error -> {
            SampleScreen(text = "Error: ${state.exception.message}")
        }
    }
}