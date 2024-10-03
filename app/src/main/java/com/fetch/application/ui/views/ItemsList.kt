package com.fetch.application.ui.views

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.material3.pulltorefresh.PullToRefreshDefaults.Indicator
import androidx.compose.material3.pulltorefresh.rememberPullToRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.fetch.application.data.ItemModel
import com.fetch.application.ui.theme.FetchPurple

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ItemsList(
    topAppBarPaddingValue: PaddingValues,
    itemModels: List<ItemModel>,
    lazyListState: LazyListState,
    onRefresh: () -> Unit,
) {
    val isRefreshing = remember { mutableStateOf(false) }
    val refreshState = rememberPullToRefreshState()
    val scrollState = rememberScrollState()

    PullToRefreshBox(
        isRefreshing = isRefreshing.value,
        onRefresh = {
            isRefreshing.value = true
            onRefresh()
            isRefreshing.value = false
        },
        state = refreshState,
        indicator =  {
            Indicator(
                modifier = Modifier.align(Alignment.TopCenter),
                isRefreshing = isRefreshing.value,
                state = refreshState
            )
        },
        modifier = Modifier
            .scrollable(
                state = scrollState,
                orientation = Orientation.Vertical,
                enabled = true
            )
            .padding(topAppBarPaddingValue)
            .background(FetchPurple)
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .fillMaxWidth()

    ) {
        LazyColumn(
            state = lazyListState
        ) {
            items(itemModels.size) { item ->
                ItemRow(itemModels[item])
            }
        }
    }
}
