package com.example.attackontitan.activities

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.attackontitan.data.model.TitanBaseInfo
import com.example.attackontitan.data.repository.MainTitanRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: MainTitanRepository
) :ViewModel() {
    private val _titanList = MutableLiveData<List<TitanBaseInfo>>()
    val titanList : LiveData<List<TitanBaseInfo>> = _titanList

    fun getTitanBaseInfo() {
        viewModelScope.launch {
            try {
                val titans = repository.getBaseTitanInfo()
                _titanList.value = titans
            } catch (e: Exception) {
                //TODO("Need to add resource class later")
            }
        }
    }
}