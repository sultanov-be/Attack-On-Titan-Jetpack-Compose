package com.example.attackontitan.ui.views.details_components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.attackontitan.utils.firstToCapital

@Composable
fun SimpleDetailsItem(title: String, content: String) {
    Row(
        modifier = Modifier
            .padding(top = 8.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            fontSize = 18.sp,
            text = title.firstToCapital(),
            textAlign = TextAlign.Start
        )
        Text(
            modifier = Modifier
                .background(color = Color.White.copy(0.5f))
                .fillMaxWidth(),
            text = content,
            textAlign = TextAlign.End
        )
    }
}