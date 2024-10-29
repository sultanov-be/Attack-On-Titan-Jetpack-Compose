package com.example.attackontitan.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
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
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.attackontitan.R
import com.example.attackontitan.ui.theme.AttackOnTitanTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val listOfEndpoints =
            listOf("Characters", "episodes", "locations", "organizations", "titans")

        setContent {
            MaterialTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainGridListView(
                        listOfStrings = listOfEndpoints,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun MainGridListView(listOfStrings: List<String>, modifier: Modifier = Modifier) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2)
    ) {
        items(listOfStrings) {
            EndPointElevatedCard(text = it, Modifier.padding(8.dp))
        }
    }
}

@Composable
fun EndPointElevatedCard(text: String, modifier: Modifier) {
    ElevatedCard(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
    ) {

        Box(Modifier.padding(6.dp)) {

            Card {
                Image(
                    painter = painterResource(R.drawable.img),
                    contentDescription = null
                )
            }

            Text(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .background(color = Color.White.copy(0.5f))
                    .fillMaxWidth(),
                text = text.uppercase(),
                textAlign = TextAlign.Center
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AttackOnTitanTheme {
        MainGridListView(listOf("Characters", "episodes", "locations", "organizations", "titans"))
    }
}