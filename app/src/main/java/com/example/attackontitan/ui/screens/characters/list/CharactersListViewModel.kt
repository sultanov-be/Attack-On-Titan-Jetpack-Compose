package com.example.attackontitan.ui.screens.characters.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.attackontitan.data.model.BaseDataModel
import com.example.attackontitan.data.repository.characters.CharactersListRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.flatMapLatest
import javax.inject.Inject

@HiltViewModel
class CharactersListViewModel @Inject constructor(
    val repository: CharactersListRepository
) : ViewModel() {

    private val _query = MutableStateFlow<String?>(null)
    val query: StateFlow<String?> = _query

    @OptIn(ExperimentalCoroutinesApi::class, FlowPreview::class)
    val charactersPagingData: Flow<PagingData<BaseDataModel>> =
        _query
            .debounce(300)
            .distinctUntilChanged()
            .flatMapLatest { query ->
                repository.getCharacters(query)
            }
            .cachedIn(viewModelScope)

    fun updateQuery(query: String) {
        _query.value = query
    }
}