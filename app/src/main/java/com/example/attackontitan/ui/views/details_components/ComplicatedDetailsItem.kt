package com.example.attackontitan.ui.views.details_components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.attackontitan.R
import com.example.attackontitan.data.model.BaseDataModel
import com.example.attackontitan.ui.navigation.Route
import com.example.attackontitan.utils.firstToCapital

@Composable
fun ComplicatedDetailsItem(title: String, list: List<String>) {
    OutlinedCard(
        modifier = Modifier.padding(4.dp),
        shape = RoundedCornerShape(4.dp),
        border = BorderStroke(1.dp, color = MaterialTheme.colorScheme.surfaceVariant)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp)
                .background(color = Color.White.copy(0.5f))
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = title.firstToCapital(),
                    fontSize = 20.sp
                )

                Image(
                    painter = painterResource(R.drawable.arrow_down_img),
                    contentDescription = null,
                    modifier = Modifier
                        .size(40.dp)
                        .padding(start = 10.dp)
                )
            }
            LazyColumn {
                items(list) { items ->
                    Text(
                        fontSize = 20.sp,
                        text = items
                    )
                }
            }
        }
    }
}

@Composable
fun ComplicatedDetailsItem(title: String, list: List<BaseDataModel>, navController: NavController) {
    OutlinedCard(
        modifier = Modifier.padding(4.dp),
        shape = RoundedCornerShape(4.dp),
        border = BorderStroke(1.dp, color = MaterialTheme.colorScheme.surfaceVariant)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp)
                .background(color = Color.White.copy(0.5f))
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = title.firstToCapital(),
                    fontSize = 20.sp
                )

                Image(
                    painter = painterResource(R.drawable.arrow_down_img),
                    contentDescription = null,
                    modifier = Modifier
                        .size(40.dp)
                        .padding(start = 10.dp)
                )
            }
            LazyColumn {
                items(list) { items ->
                    Text(
                        modifier = Modifier.clickable {
                            navController.navigate(Route.CharacterDetailsScreen.withArgs(items.id.toString()))
                        },
                        fontSize = 20.sp,
                        text = items.name
                    )
                }
            }
        }
    }
}