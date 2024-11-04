package com.example.attackontitan.data.model

data class ApiResponse<T>(
    val info: Info,
    val results: List<T>
)