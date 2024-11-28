package com.example.attackontitan.ui.screens.organizations

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.attackontitan.data.model.BaseDataModel
import com.example.attackontitan.data.repository.organizations.OrganizationsListRepository
import com.example.attackontitan.utils.BaseListViewModel
import com.example.attackontitan.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OrganizationsListViewModel @Inject constructor(
    private val repository: OrganizationsListRepository
) : BaseListViewModel<BaseDataModel>() {

    private val _organizationsList = MutableLiveData<Resource<List<BaseDataModel>>>()
    override val list: LiveData<Resource<List<BaseDataModel>>> = _organizationsList

    init {
        getOrganizationsBaseInfo()
    }

    private fun getOrganizationsBaseInfo() {
        _organizationsList.value = Resource.Loading
        viewModelScope.launch {
            when (val result = repository.getOrganizationsList()) {
                is Resource.Success -> _organizationsList.value = result
                is Resource.Error -> Log.e(
                    "OrganizationsListViewModel",
                    "Error fetching titans: ${result.exception.message}"
                )
                else -> {}
            }
        }
    }
}