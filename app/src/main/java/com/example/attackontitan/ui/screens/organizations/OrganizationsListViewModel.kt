package com.example.attackontitan.ui.screens.organizations

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.attackontitan.data.model.OrganizationBaseInfo
import com.example.attackontitan.data.repository.OrganizationsListRepository
import com.example.attackontitan.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OrganizationsListViewModel @Inject constructor(
    private val repository: OrganizationsListRepository
) : ViewModel() {

    private val _organizationsList = MutableLiveData<List<OrganizationBaseInfo>>()
    val organizationsList : LiveData<List<OrganizationBaseInfo>> = _organizationsList

    init {
        getTitanBaseInfo()
    }

    private fun getTitanBaseInfo() {
        viewModelScope.launch {
            when (val result = repository.getOrganizationsList()) {
                is Resource.Success -> _organizationsList.value = result.data
                is Resource.Error -> Log.e(
                    "OrganizationsListViewModel",
                    "Error fetching titans: ${result.exception.message}"
                )
            }
        }
    }
}