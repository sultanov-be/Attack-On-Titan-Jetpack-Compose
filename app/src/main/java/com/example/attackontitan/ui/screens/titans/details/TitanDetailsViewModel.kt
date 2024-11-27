package com.example.attackontitan.ui.screens.titans.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.attackontitan.data.model.characters.CharacterBaseInfo
import com.example.attackontitan.data.model.titans.TitanDetails
import com.example.attackontitan.data.repository.titans.TitansListRepository
import com.example.attackontitan.utils.Resource
import com.example.attackontitan.utils.extractIdFromUrl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TitanDetailsViewModel @Inject constructor(
    private val repository: TitansListRepository
) : ViewModel() {

    private val _titanDetails = MutableLiveData<Resource<TitanDetails>>()
    val titanDetails: LiveData<Resource<TitanDetails>> = _titanDetails

    private val _characterDetails = MutableLiveData<Resource<CharacterBaseInfo>>()
    val characterDetails: LiveData<Resource<CharacterBaseInfo>> = _characterDetails

    private val _formerInheritorNames = MutableLiveData<Resource<List<CharacterBaseInfo>>>()
    val formerInheritorNames: LiveData<Resource<List<CharacterBaseInfo>>> = _formerInheritorNames

    fun getTitanDetails(id: Int) {
        viewModelScope.launch {
            _titanDetails.value = Resource.Loading
            _titanDetails.value = repository.getTitanDetails(id)
        }
    }

    fun getCharacterName(url: String) {
        viewModelScope.launch {
            val id = url.extractIdFromUrl()
            _characterDetails.value = Resource.Loading

            if (id != null) _characterDetails.value = repository.getCharacterName(id)
            else _characterDetails.value = Resource.Error(Exception("Invalid URL: $url"))
        }
    }

    fun getFormerInheritorNames(urls: List<String>) {
        viewModelScope.launch {
            _formerInheritorNames.value = Resource.Loading
            val names = mutableListOf<CharacterBaseInfo>()
            val errors = mutableListOf<String>()

            for (url in urls) {
                val result = url.extractIdFromUrl()?.let { repository.getCharacterName(it) }
                when (result) {
                    is Resource.Success -> names.add(result.data)
                    is Resource.Error -> errors.add(url)
                    else -> Unit
                }
            }

            if (errors.isNotEmpty()) {
                _formerInheritorNames.value = Resource.Error(
                    Exception("Failed to fetch names for URLs: ${errors.joinToString(", ")}")
                )
            } else {
                _formerInheritorNames.value = Resource.Success(names)
            }
        }

    }
}