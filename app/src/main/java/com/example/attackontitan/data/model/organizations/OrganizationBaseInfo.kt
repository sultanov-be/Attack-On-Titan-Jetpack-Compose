package com.example.attackontitan.data.model.organizations

data class OrganizationBaseInfo(
    val id: Int,
    val name: String,
    val img: String,
    val notable_members: List<String>,
    val affiliation: String,
)