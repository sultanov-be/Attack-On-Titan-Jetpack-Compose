package com.example.attackontitan.ui.views.details_components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
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
    OutlinedCard(
        modifier = Modifier.padding(4.dp),
        shape = RoundedCornerShape(4.dp),
        border = BorderStroke(1.dp, color = MaterialTheme.colorScheme.surfaceVariant)
    ) {
        Row(
            modifier = Modifier
                .background(color = Color.White.copy(0.5f))
                .padding(top = 4.dp, start = 4.dp, end = 8.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier.padding(start = 4.dp),
                fontSize = 20.sp,
                text = title.firstToCapital(),
                textAlign = TextAlign.Start
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth().padding(end = 4.dp),
                text = content,
                textAlign = TextAlign.End,
                fontSize = 18.sp
            )
        }
    }
}