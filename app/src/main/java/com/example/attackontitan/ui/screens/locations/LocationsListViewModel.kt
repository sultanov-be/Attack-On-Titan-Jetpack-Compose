package com.example.attackontitan.ui.screens.locations

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.attackontitan.data.model.locations.LocationDetails
import com.example.attackontitan.data.repository.locations.LocationsListRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class LocationsListViewModel @Inject constructor(
    val repository: LocationsListRepository
) : ViewModel() {

    val locationsPagingData: Flow<PagingData<LocationDetails>> =
        repository.getLocations().cachedIn(viewModelScope)

}