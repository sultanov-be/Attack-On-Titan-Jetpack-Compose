package com.example.attackontitan.ui.screens.characters.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.attackontitan.data.model.characters.CharacterDetails
import com.example.attackontitan.data.repository.characters.CharactersListRepository
import com.example.attackontitan.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterDetailsViewModel @Inject constructor(
    private val repository: CharactersListRepository
) : ViewModel() {
    private val _characterDetails = MutableStateFlow<Resource<CharacterDetails>>(Resource.Loading)
    val characterDetails: StateFlow<Resource<CharacterDetails>> get() = _characterDetails

    fun loadCharacterDetails(id: Int) {
        viewModelScope.launch {
            repository.getCharacterDetails(id)
                .onStart {
                    _characterDetails.value = Resource.Loading
                }
                .catch { e ->
                    _characterDetails.value = Resource.Error(Exception(e))
                }
                .collect { result ->
                    _characterDetails.value = result
                }
        }
    }
}