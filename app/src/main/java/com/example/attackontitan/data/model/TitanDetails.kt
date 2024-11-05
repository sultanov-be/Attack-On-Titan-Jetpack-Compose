package com.example.attackontitan.data.model

data class TitanDetails(
    val id: Int,
    val name: String,
    val img: String,
    val height: String,
    val abilities: List<String>,
    val current_inheritor: String,
    val former_inheritors: List<String>,
    val allegiance: String,
)