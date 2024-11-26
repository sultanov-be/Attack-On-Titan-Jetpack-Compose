package com.example.attackontitan.ui.screens.characters

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.attackontitan.data.model.characters.CharacterBaseInfo
import com.example.attackontitan.data.repository.characters.CharactersListRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class CharactersListViewModel @Inject constructor(
    private val repository: CharactersListRepository
) : ViewModel() {

    val charactersPagingData: Flow<PagingData<CharacterBaseInfo>> =
        repository.getCharacters().cachedIn(viewModelScope)

}