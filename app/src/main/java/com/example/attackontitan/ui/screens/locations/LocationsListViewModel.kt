package com.example.attackontitan.ui.screens.locations

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.attackontitan.data.model.LocationBaseInfo
import com.example.attackontitan.data.repository.locations.LocationsListRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class LocationsListViewModel @Inject constructor(
    private val repository: LocationsListRepository
) : ViewModel() {

    val locationsPagingData: Flow<PagingData<LocationBaseInfo>> =
        repository.getLocations().cachedIn(viewModelScope)

}