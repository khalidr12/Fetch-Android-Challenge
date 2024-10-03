package com.fetch.application.ui.views

import androidx.compose.foundation.lazy.LazyListState
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

    // each tab needs a scroll state, so user doesn't need to scroll down every time they switch tabs
    // list size is hardcoded right now, but in later iterations may be generalized
    val scrollStates = remember { List(4) { LazyListState() } }

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
                LoadingComponent()
            }
            is UiState.Loaded -> {
                val lazyListState = scrollStates[selectedIndex.value]
                val items = (uiState as UiState.Loaded<List<ItemModel>>).data
                ItemsList(it, items, lazyListState) {
                    viewModel.refresh(selectedIndex.value + 1)
                }
            }
            is UiState.Error -> {
                val error = (uiState as UiState.Error).exception
                ErrorComponent(error, it)
            }
        }
    }
}