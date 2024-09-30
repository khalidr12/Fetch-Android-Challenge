package com.fetch.application.ui.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.fetch.application.data.ItemModel
import com.fetch.application.ui.theme.FetchGold
import com.fetch.application.ui.theme.FetchPurple

@Composable
fun ItemRow(
    itemModel: ItemModel
) {
    Row(
        modifier = Modifier
            .height(50.dp)
            .fillMaxWidth()
            .background(FetchPurple)
    ) {
        Column {
            Text(text = itemModel.name.toString(), color = FetchGold)
            Text(text = itemModel.id.toString(), color = FetchGold)
            Divider(thickness = 1.dp, color = FetchGold)
        }
        
    }
}