package com.example.attackontitan.utils

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

abstract class BaseListViewModel<T> : ViewModel() {
    abstract val list: LiveData<Resource<List<T>>>
}