package com.example.attackontitan.ui.views.details_components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.attackontitan.R
import com.example.attackontitan.utils.firstToCapital

@Composable
fun ComplicatedDetailsItem(title: String, list: List<String>) {
    var isShown by remember {
        mutableStateOf(false)
    }

    Column(
        modifier = Modifier.fillMaxWidth().padding(5.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = title.firstToCapital(),
                fontSize = 18.sp
            )

            Image(
                painter = painterResource(R.drawable.arrow_down_img),
                contentDescription = null,
                modifier = Modifier
                    .size(40.dp)
                    .padding(start = 10.dp)
                    .clickable {
                        isShown = !isShown
                    },
            )
        }
        if (isShown) {
            LazyColumn {
                items(list) { items ->
                    Text(text = items)
                }
            }
        }
    }
}