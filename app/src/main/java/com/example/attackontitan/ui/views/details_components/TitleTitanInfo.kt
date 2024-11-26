package com.example.attackontitan.ui.views.details_components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.attackontitan.R

@Composable
fun TitleTitanInfo(name: String, img: String) {
    Text(
        text = name,
        fontSize = 32.sp,
        modifier = Modifier.fillMaxWidth(),
        textAlign = TextAlign.Center
    )
    Card(
        modifier = Modifier.padding(vertical = 20.dp),
        shape = CircleShape
    ) {
        AsyncImage(
            model = img,
            placeholder = painterResource(R.drawable.img),
            error = painterResource(R.drawable.img),
            contentDescription = null,
            modifier = Modifier.size(200.dp),
            contentScale = ContentScale.Crop
        )
    }
}