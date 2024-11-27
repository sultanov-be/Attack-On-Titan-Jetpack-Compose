package com.example.attackontitan.utils

fun String.extractIdFromUrl(): Int? {
    return this.substringAfterLast('/').toIntOrNull()
}

fun String.firstToCapital(): String {
   val regex = "(\\b[a-z])".toRegex()
    return this.replace(regex) {it.value.uppercase()}
}