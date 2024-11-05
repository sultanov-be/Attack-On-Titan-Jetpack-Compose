package com.example.attackontitan.ui.screens.details

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.example.attackontitan.R
import com.example.attackontitan.data.model.TitanDetails
import com.example.attackontitan.ui.views.GenericLoadingView
import com.example.attackontitan.ui.views.details_components.ComplicatedDetailsItem
import com.example.attackontitan.ui.views.details_components.SimpleDetailsItem
import com.example.attackontitan.utils.Resource

@Composable
fun DetailsScreen(itemId: String) {
    val detailsViewModel: DetailsViewModel = hiltViewModel()

    LaunchedEffect(itemId) {
        detailsViewModel.getTitanDetails(itemId.toInt())
    }

    val titanDetails by detailsViewModel.titanDetails.observeAsState()

    when (titanDetails) {
        is Resource.Loading -> {
            GenericLoadingView()
        }

        is Resource.Success -> {
            val details = (titanDetails as Resource.Success).data
            DetailsScreenBody(details)
        }

        else -> {
            Text("Error")
        }
    }
}

@Composable
fun DetailsScreenBody(details: TitanDetails) {
    Column(
        modifier = Modifier
            .padding(top = 30.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = details.name,
            fontSize = 32.sp,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )
        Card(
            modifier = Modifier.size(200.dp),
            shape = CircleShape
        ) {
            AsyncImage(
                model = details.img,
                placeholder = painterResource(R.drawable.img),
                error = painterResource(R.drawable.img),
                contentDescription = null,
                modifier = Modifier.size(200.dp),
                contentScale = ContentScale.Crop
            )
        }
        SimpleDetailsItem(title = "Height", content = details.height)
        SimpleDetailsItem(title = "Current inheritor", content = details.current_inheritor)
        SimpleDetailsItem(title = "allegiance", content = details.allegiance)
        ComplicatedDetailsItem(list = details.former_inheritors)
        ComplicatedDetailsItem(list = details.abilities)
    }
}