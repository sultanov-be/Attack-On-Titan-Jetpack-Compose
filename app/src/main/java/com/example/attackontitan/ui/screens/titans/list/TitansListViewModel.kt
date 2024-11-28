package com.example.attackontitan.ui.screens.titans.list

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.attackontitan.data.model.BaseDataModel
import com.example.attackontitan.data.repository.titans.TitansListRepository
import com.example.attackontitan.utils.BaseListViewModel
import com.example.attackontitan.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TitansListViewModel @Inject constructor(
    private val repository: TitansListRepository
) : BaseListViewModel<BaseDataModel>() {

    private val _titanList = MutableLiveData<Resource<List<BaseDataModel>>>()
    override val list: LiveData<Resource<List<BaseDataModel>>> = _titanList

    init {
        getTitanBaseInfo()
    }

    private fun getTitanBaseInfo() {
        viewModelScope.launch {
            when (val result = repository.getTitansList()) {
                is Resource.Success -> _titanList.value = result
                is Resource.Error -> Log.e(
                    "TitansListViewModel",
                    "Error fetching titans: ${result.exception.message}"
                )
                else -> {}
            }
        }
    }
}