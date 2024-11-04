package com.example.attackontitan.ui.screens.organizations

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.attackontitan.R
import com.example.attackontitan.data.model.OrganizationBaseInfo

@Composable
fun OrganizationsListScreen(organizationsListViewModel: OrganizationsListViewModel) {
    TitanGridListView(viewModel = organizationsListViewModel)
}

@Composable
fun TitanGridListView(
    modifier: Modifier = Modifier,
    viewModel: OrganizationsListViewModel
) {
    val titans by viewModel.organizationsList.observeAsState(emptyList())

    if (titans.isEmpty()) {
        CircularProgressIndicator()
        Text("Загрузка титанов...")
    } else {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = modifier
        ) {
            items(titans) { item ->
                EndPointElevatedCard(item = item, modifier = Modifier.padding(8.dp))
            }
        }
    }
}

@Composable
fun EndPointElevatedCard(item: OrganizationBaseInfo, modifier: Modifier) {
    ElevatedCard(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
    ) {

        Box(Modifier.padding(6.dp)) {
            Card {
                AsyncImage(
                    model = item.img,
                    contentDescription = item.name,
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
                text = item.name.uppercase(),
                textAlign = TextAlign.Center
            )
        }
    }
}