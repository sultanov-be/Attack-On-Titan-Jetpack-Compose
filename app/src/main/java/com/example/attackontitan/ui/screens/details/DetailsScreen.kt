package com.example.attackontitan.ui.screens.details

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

@Composable
fun DetailsScreen(itemId: String) {
    Text(
        text = itemId,
        modifier = Modifier.fillMaxWidth(),
        fontSize = 32.sp,
        textAlign = TextAlign.Center
    )
}