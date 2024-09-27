package com.fetch.application.repository

import com.fetch.application.api.Item
import com.fetch.application.api.ItemAPIService
import com.fetch.application.parser.extractNumericValue

class ItemRepositoryImpl (
    private val apiService: ItemAPIService
) : ItemRepository {
    override suspend fun fetchItems(listId: Int): List<Item> {
        return apiService
            .getItems()
            .filter { it.listId == listId }
            .filter { !it.name.isNullOrBlank() }
            .sortedWith(compareBy { extractNumericValue(it.name) } )
    }
}