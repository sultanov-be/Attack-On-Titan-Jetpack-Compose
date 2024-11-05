package com.example.attackontitan.ui.views

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.attackontitan.R

@Composable
fun ListItem(
    imageUrl: String,
    title: String
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.surfaceContainer),
        shape = RectangleShape
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Card(shape = RoundedCornerShape(10.dp)) {
                AsyncImage(
                    model = imageUrl,
                    contentDescription = title,
                    placeholder = painterResource(R.drawable.img),
                    error = painterResource(R.drawable.img),
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(150.dp)
                        .padding(2.dp)
                )
            }
            Text(
                modifier = Modifier
                    .background(color = Color.White.copy(0.5f))
                    .fillMaxWidth(),
                text = title.uppercase(),
                textAlign = TextAlign.Center
            )
        }
    }
}