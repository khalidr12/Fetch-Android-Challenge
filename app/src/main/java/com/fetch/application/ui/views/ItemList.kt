package com.fetch.application.ui.views

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import com.fetch.application.ui.viewmodel.ItemViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun ItemList(viewModel: ItemViewModel = koinViewModel()) {
    val items = remember { viewModel.items }

    LaunchedEffect(Unit) {
        viewModel.fetchUsers()
    }

    LazyColumn {
        items(items.size) { item ->
            Text(text = items[item].id.toString(), color = Color.White)
        }
    }
}