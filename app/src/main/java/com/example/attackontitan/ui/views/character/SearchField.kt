package com.example.attackontitan.ui.views.character

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.example.attackontitan.ui.screens.characters.list.CharactersListViewModel


@Composable
fun SearchField(viewModel: CharactersListViewModel) {
    TextField(
        modifier = Modifier.fillMaxWidth(),
        value = viewModel.query.collectAsState().value.orEmpty(),
        trailingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search Icon"
            )
        },
        onValueChange = {query->
            viewModel.updateQuery(query)
        },
        placeholder = { Text("Search by name") }
    )
}