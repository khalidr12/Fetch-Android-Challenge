package com.fetch.application.repository

import com.fetch.application.api.Item

interface ItemRepository {
    suspend fun fetchItems(listId: Int): List<Item>
}