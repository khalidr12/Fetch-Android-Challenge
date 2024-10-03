package com.fetch.application.ui.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fetch.application.ui.theme.FetchGold
import com.fetch.application.ui.theme.FetchPurple
import com.valentinilk.shimmer.shimmer

@Composable
fun LoadingComponent() {
    Column(
        Modifier
            .background(FetchPurple)
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(top = 60.dp)
    ) {
        LoadingListItem()
        LoadingListItem()
        LoadingListItem()
        LoadingListItem()
        LoadingListItem()
        LoadingListItem()
        LoadingListItem()
        LoadingListItem()
        LoadingListItem()
    }
}

@Composable
fun LoadingListItem() {
    Row(
        modifier = Modifier
            .shimmer()
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(24.dp)
                    .background(FetchGold),
            )
            Box(
                modifier = Modifier
                    .size(120.dp, 20.dp)
                    .background(FetchGold),
            )
        }
    }
}

@Preview
@Composable
fun LoadingPreview() {
    LoadingComponent()
}