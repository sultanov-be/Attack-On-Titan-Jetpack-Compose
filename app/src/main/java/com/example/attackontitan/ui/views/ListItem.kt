package com.example.attackontitan.ui.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.attackontitan.R

@Composable
fun ListItem(
    modifier: Modifier = Modifier.padding(8.dp),
    imageUrl: String,
    title: String
) {
    ElevatedCard(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
    ) {
        Box(Modifier.padding(6.dp)) {
            Card {
                AsyncImage(
                    model = imageUrl,
                    contentDescription = title,
                    placeholder = painterResource(R.drawable.img),
                    error = painterResource(R.drawable.img),
                    contentScale = ContentScale.FillWidth
                )
            }

            Text(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .background(color = Color.White.copy(0.5f))
                    .fillMaxWidth(),
                text = title.uppercase(),
                textAlign = TextAlign.Center
            )
        }
    }
}