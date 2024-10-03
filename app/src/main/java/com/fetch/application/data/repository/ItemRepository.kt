package com.fetch.application.data.repository

import com.fetch.application.data.ItemModel

interface ItemRepository {
    suspend fun fetchItemsFromAPI()
    suspend fun fetchItemsFromDB(listId: Int): List<ItemModel>
    suspend fun refresh(listId: Int) : List<ItemModel>
}