package com.fetch.application.ui.views

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.fetch.application.ui.theme.FetchGold

@Composable
fun EmptyComponent(
    paddingValues: PaddingValues
) {
    Box(modifier = Modifier
        .padding(paddingValues)
        .padding(vertical = 8.dp)
    ) {
        Text(text = "There are currently no items. Try again later", color = FetchGold)
    }
}