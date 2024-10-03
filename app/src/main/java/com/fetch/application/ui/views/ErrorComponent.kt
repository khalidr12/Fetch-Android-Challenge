package com.fetch.application.ui.views

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.material3.pulltorefresh.PullToRefreshDefaults
import androidx.compose.material3.pulltorefresh.rememberPullToRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.fetch.application.ui.theme.FetchGold
import com.fetch.application.ui.theme.FetchPurple
import java.lang.Exception

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ErrorComponent(
    error: Exception,
    paddingValues: PaddingValues,
    onRefresh: () -> Unit
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
            PullToRefreshDefaults.Indicator(
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
            .padding(paddingValues)
            .background(FetchPurple)
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .fillMaxSize()

    ){
        Text(text = "Error: ${error.message}", color = FetchGold)
    }
}