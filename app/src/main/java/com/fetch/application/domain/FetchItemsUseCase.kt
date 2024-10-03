package com.fetch.application.domain

import com.fetch.application.data.ItemModel
import com.fetch.application.data.repository.ItemRepository
import com.fetch.application.ui.UiState

class FetchItemsUseCase(private val itemRepository: ItemRepository) {

    suspend fun fetchFromAPI() {
        itemRepository.fetchItemsFromAPI()
    }
    suspend fun fetchFromDB(listId: Int): UiState<List<ItemModel>> {
        return try {
            val items = itemRepository.fetchItemsFromDB(listId)
            UiState.Loaded(items)
        } catch (e: Exception) {
            UiState.Error(e)
        }
    }

    suspend fun refresh(listId: Int): UiState<List<ItemModel>> {
        return try {
            val items = itemRepository.refresh(listId)
            UiState.Loaded(items)
        } catch (e: Exception) {
            UiState.Error(e)
        }
    }
}