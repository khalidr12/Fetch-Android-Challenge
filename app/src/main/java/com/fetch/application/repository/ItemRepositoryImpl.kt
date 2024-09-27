package com.fetch.application.repository

import com.fetch.application.api.Item
import com.fetch.application.api.ItemAPIService

class ItemRepositoryImpl (
    private val apiService: ItemAPIService
) : ItemRepository{
    override suspend fun fetchItems(): List<Item> {
        return apiService.getItems()
    }
}