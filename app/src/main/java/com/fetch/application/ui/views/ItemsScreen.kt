package com.fetch.application.ui.views

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import com.fetch.application.data.ItemModel
import com.fetch.application.ui.UiState
import com.fetch.application.ui.viewmodel.ItemViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun ItemsScreen(viewModel: ItemViewModel = koinViewModel()) {
    val selectedIndex = remember { mutableStateOf(0) }
    val uiState by viewModel.uiState.collectAsState()
    Scaffold (
        topBar = {
            TopAppBar(
                selectedIndex = selectedIndex,
                onClick = {
                    selectedIndex.value = it - 1
                    viewModel.fetchItems(it)
                }
            )
        }
    ) {
        when (uiState) {
            is UiState.Loading -> {
                CircularProgressIndicator()
            }
            is UiState.Loaded -> {
                val items = (uiState as UiState.Loaded<List<ItemModel>>).data
                ItemsList(it, items) {
                    viewModel.refresh(selectedIndex.value)
                }
            }
            is UiState.Error -> {
                val error = (uiState as UiState.Error).exception
                Text(text = "Error: ${error.message}", color = Color.Red)
            }
        }
    }
}