package com.example.attackontitan.ui.screens.titans

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.attackontitan.data.model.TitanBaseInfo
import com.example.attackontitan.data.repository.MainTitanRepository
import com.example.attackontitan.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TitanListViewModel @Inject constructor(
    private val repository: MainTitanRepository
) : ViewModel() {

    private val _titanList = MutableLiveData<List<TitanBaseInfo>>()
    val titanList : LiveData<List<TitanBaseInfo>> = _titanList

    init {
        getTitanBaseInfo()
    }

    private fun getTitanBaseInfo() {
        viewModelScope.launch {
            when (val result = repository.getBaseTitanInfo()) {
                is Resource.Success -> _titanList.value = result.data
                is Resource.Error -> Log.e(
                    "MainViewModel",
                    "Error fetching titans: ${result.exception.message}"
                )
            }
        }
    }
}