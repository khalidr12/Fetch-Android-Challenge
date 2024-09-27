package com.fetch.application.ui.views

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.fetch.application.ui.viewmodel.ItemViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun ItemList(viewModel: ItemViewModel = koinViewModel()) {
    val selectedIndex = remember { mutableStateOf(0) }
    val items = remember { viewModel.items }
    Scaffold (
        topBar = {
            ScrollableTabRow(
                selectedTabIndex = selectedIndex.value,
                indicator = {},
                divider = {},
                containerColor = Color.Transparent,
                edgePadding = 0.dp,
            ) {
                for (listId in 1..4){
                    ItemTab(
                        listId = listId,
                        onClick = {
                            selectedIndex.value = it - 1
                            viewModel.fetchItems(it)
                        },
                        selectedIndex = selectedIndex.value,
                    )
                }
            }
        }
    ) {
        LazyColumn(
            Modifier
                .padding(it)
                .fillMaxWidth()
                .scrollable(
                    state = rememberScrollState(),
                    orientation = Orientation.Vertical
                )
        ) {
            items(items.size) { item ->
                Text(text = items[item].name.toString(), color = Color.White)
            }
        }
    }
}