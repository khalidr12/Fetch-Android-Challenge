package com.fetch.application.ui.views

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.fetch.application.R

@Composable
fun ItemTab(
    onClick: (listId: Int) -> Unit,
    listId: Int,
    selectedIndex: Int,
) {
    Box(
        modifier = Modifier
            .width(120.dp)
            .height(50.dp)
            .padding(horizontal = 5.dp),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = stringResource(R.string.list_id, listId),
            modifier = Modifier
                .clickable { onClick(listId) }
                .clip(RoundedCornerShape(10.dp))
                .width(100.dp)
                .background(
                    if (selectedIndex == (listId - 1)) Color.Blue else Color.White
                ),
            textAlign = TextAlign.Center
        )
    }

}