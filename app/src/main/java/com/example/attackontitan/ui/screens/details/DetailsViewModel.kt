package com.example.attackontitan.ui.screens.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.attackontitan.data.model.CharacterBaseInfo
import com.example.attackontitan.data.model.TitanDetails
import com.example.attackontitan.data.repository.TitansListRepository
import com.example.attackontitan.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val repository: TitansListRepository
) : ViewModel() {

    private val _titanDetails = MutableLiveData<Resource<TitanDetails>>()
    val titanDetails: LiveData<Resource<TitanDetails>> = _titanDetails

    private val _characterDetails = MutableLiveData<Resource<CharacterBaseInfo>>()
    val characterDetails: LiveData<Resource<CharacterBaseInfo>> = _characterDetails

    fun getTitanDetails(id: Int) {
        viewModelScope.launch {
            _titanDetails.value = Resource.Loading
            _titanDetails.value = repository.getTitanDetails(id)
        }
    }

    fun getCharacterName(id: Int) {
        viewModelScope.launch {
            _characterDetails.value = Resource.Loading
            _characterDetails.value = repository.getCharacterName(id)
        }
    }
}