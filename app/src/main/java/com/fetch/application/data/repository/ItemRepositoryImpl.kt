package com.fetch.application.data.repository

import com.fetch.application.data.ItemModel
import com.fetch.application.data.api.ItemAPIService
import com.fetch.application.data.room.ItemDao
import com.fetch.application.data.toModel

class ItemRepositoryImpl (
    private val apiService: ItemAPIService,
    private val itemDao: ItemDao
) : ItemRepository {
    /**
     * Initial fetch from API when a user opens the app, and populate lcoal db
     * */
    override suspend fun fetchItemsFromAPI() {
        val fetchedItems = apiService.getItems()
            .filter { !it.name.isNullOrBlank() }
            .sortedBy { it.id }

        itemDao.insertItems(fetchedItems)
    }


    /**
     * Method to fetch data from local DB; ie when switching between tabs
    * */
    override suspend fun fetchItemsFromDB(listId: Int): List<ItemModel> {

        val localItems = itemDao.getItemsByListId(listId).map {
            it.toModel()
        }

        return localItems
    }

    /**
     * Method to refresh items in current tab. Will clear items in local db and then repopulate from API
     * Note that there is currently no method to request specific items from the api, so all the data
     * needs to be pulled regardless
     * */
    override suspend fun refresh(listId: Int): List<ItemModel> {
        itemDao.clearItems()

        fetchItemsFromAPI()

        return fetchItemsFromDB(listId)
    }
}