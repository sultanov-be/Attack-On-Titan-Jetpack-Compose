package com.example.attackontitan.ui.views

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun GenericLoadingView() {
    CircularProgressIndicator()
    Text("Загрузка...")
}