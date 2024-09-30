package com.fetch.application.ui.views

import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.fetch.application.data.ItemModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ItemsList(
    topAppBarPaddingValue: PaddingValues,
    itemModels: List<ItemModel>,
    onRefresh: () -> Unit,
) {
    var isRefreshing = remember {
        mutableStateOf(false)
    }
    PullToRefreshBox(
        isRefreshing = isRefreshing.value,
        onRefresh = {
            isRefreshing.value = true
            onRefresh()
            isRefreshing.value = false
        }
    ) {
        LazyColumn(
            modifier = Modifier
                .padding(topAppBarPaddingValue)
                .fillMaxWidth()
                .scrollable(
                    state = rememberScrollState(),
                    orientation = Orientation.Vertical
                ),
        ) {
            items(itemModels.size) { item ->
                ItemRow(itemModels[item])
            }
        }
    }
}
