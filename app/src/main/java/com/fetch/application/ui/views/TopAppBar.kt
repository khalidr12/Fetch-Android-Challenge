package com.fetch.application.ui.views

import androidx.compose.material3.ScrollableTabRow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun TopAppBar(
    selectedIndex: MutableState<Int>,
    onClick: (Int) -> Unit
) {
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
                    onClick(it)
                },
                selectedIndex = selectedIndex.value,
            )
        }
    }
}