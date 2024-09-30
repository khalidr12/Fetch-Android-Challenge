package com.fetch.application.data.repository

import com.fetch.application.data.ItemModel
import com.fetch.application.data.api.ItemAPIService
import com.fetch.application.data.room.ItemDao
import com.fetch.application.data.toModel

class ItemRepositoryImpl (
    private val apiService: ItemAPIService,
    private val itemDao: ItemDao
) : ItemRepository {
    override suspend fun fetchItems(listId: Int): List<ItemModel> {
        val localItems = itemDao.getItemsByListId(listId).map {
            it.toModel()
        }
        if (localItems.isNotEmpty()) {
            return localItems
        }

        val fetchedItems = apiService.getItems()
            .filter { it.listId == listId }
            .filter { !it.name.isNullOrBlank() }
            .sortedBy { it.id }

        itemDao.insertItems(fetchedItems)

        return fetchedItems.map {
            it.toModel()
        }
    }

    override suspend fun refresh(listId: Int): List<ItemModel> {
        itemDao.clearItems()

        val fetchedItems = apiService.getItems()
            .filter { it.listId == listId }
            .filter { !it.name.isNullOrBlank() }
            .sortedBy { it.id }

        itemDao.insertItems(fetchedItems)

        return itemDao.getItemsByListId(listId).map {
            it.toModel()
        }
    }
}