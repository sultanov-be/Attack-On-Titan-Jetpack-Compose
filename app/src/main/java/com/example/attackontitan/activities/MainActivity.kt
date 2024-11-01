package com.example.attackontitan.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import com.example.attackontitan.R
import com.example.attackontitan.data.model.TitanBaseInfo
import com.example.attackontitan.ui.theme.AttackOnTitanTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            MaterialTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainGridListView(
                        viewModel = viewModel,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun MainGridListView(
    modifier: Modifier = Modifier,
    viewModel: MainViewModel
) {
    val titans by viewModel.titanList.observeAsState(emptyList())

    if (titans.isEmpty()) {
        CircularProgressIndicator()
        Text("Загрузка титанов...")
    } else {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = modifier
        ) {
            items(titans) { titan ->
                EndPointElevatedCard(titan = titan, modifier = Modifier.padding(8.dp))
            }
        }
    }
}

@Composable
fun EndPointElevatedCard(titan: TitanBaseInfo, modifier: Modifier) {
    ElevatedCard(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
    ) {

        Box(Modifier.padding(6.dp)) {
            Card {
                AsyncImage(
                    model = titan.img,
                    contentDescription = titan.name,
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
                text = titan.name.uppercase(),
                textAlign = TextAlign.Center
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AttackOnTitanTheme {
    }
}