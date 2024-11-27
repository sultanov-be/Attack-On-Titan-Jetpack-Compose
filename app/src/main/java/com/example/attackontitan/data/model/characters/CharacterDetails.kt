package com.example.attackontitan.data.model.characters

data class CharacterDetails(
    val id: Int,
    val name: String,
    val img: String,
    val alias: List<String>,
    val species: List<String>,
    val gender: String,
    val age: Int,
    val birthplace: String,
    val residence: String,
    val status: String,
    val occupation: String,
    val groups: List<Groups>,
    val relatives: List<Relatives>
)

data class Relatives(
    val family : String,
    val members: List<String>
)

data class Groups(
    val name: String,
    val sub_groups: List<String>
)