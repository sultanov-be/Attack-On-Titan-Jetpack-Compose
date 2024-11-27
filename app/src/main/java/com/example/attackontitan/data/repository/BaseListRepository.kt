package com.example.attackontitan.data.repository

import com.example.attackontitan.utils.Resource

interface BaseListRepository<T> {
    suspend fun getList(): Resource<List<T>>
}