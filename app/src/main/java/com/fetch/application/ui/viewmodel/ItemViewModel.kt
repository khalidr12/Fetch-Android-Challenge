package com.fetch.application.ui.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fetch.application.api.Item
import com.fetch.application.repository.ItemRepository
import kotlinx.coroutines.launch

class ItemViewModel(
    private val itemRepository: ItemRepository
) : ViewModel() {
    private var _items =  mutableStateListOf<Item>()
    val items: List<Item> = _items

    init {
        fetchItems(1)
    }

    fun fetchItems(listId: Int) {
        viewModelScope.launch {
            _items.clear()
            val fetchedItems = itemRepository.fetchItems(listId)
            _items.addAll(fetchedItems)
            println(items)
        }
    }
}