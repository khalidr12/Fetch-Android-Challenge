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
        /**
         * Assuming that there is no new content that gets posted to this API
         * Would need to revamp this to periodically check for new data, and delete
         * stale data automatically.
         *
         * Current impl: Check if the local db has data, otherwise refetch from api
         * */

        val localItems = itemDao.getItemsByListId(listId).map {
            it.toModel()
        }

        if (localItems.isNotEmpty()) {
            return localItems
        }

        // Fetching from API since there is currently no data in the db
        // in the instances where id is not null or blank, the name matches the id, so we filter by it

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
        // when a user refreshes, we will clear all existing data, and fetch latest
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