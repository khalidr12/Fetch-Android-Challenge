package com.fetch.application.ui.views

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.fetch.application.R
import com.fetch.application.ui.theme.FetchGold
import com.fetch.application.ui.theme.FetchPurple

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
            .background(
                if (selectedIndex == (listId - 1)) FetchPurple else FetchGold
            )
            .padding(horizontal = 5.dp),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = stringResource(R.string.list_id, listId),
            modifier = Modifier
                .clickable { onClick(listId) }
                .width(100.dp),
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            color = if (selectedIndex == (listId - 1)) FetchGold else FetchPurple
        )
    }

}