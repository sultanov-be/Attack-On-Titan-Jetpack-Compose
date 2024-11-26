package com.example.attackontitan.ui.screens.titans

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.attackontitan.data.model.titans.TitanBaseInfo
import com.example.attackontitan.data.repository.titans.TitansListRepository
import com.example.attackontitan.utils.BaseListViewModel
import com.example.attackontitan.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TitansListViewModel @Inject constructor(
    private val repository: TitansListRepository
) : BaseListViewModel<TitanBaseInfo>() {

    private val _titanList = MutableLiveData<Resource<List<TitanBaseInfo>>>()
    override val list: LiveData<Resource<List<TitanBaseInfo>>> = _titanList

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