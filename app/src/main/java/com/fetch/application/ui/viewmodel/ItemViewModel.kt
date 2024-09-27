package com.fetch.application.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fetch.application.api.Item
import com.fetch.application.repository.ItemRepository
import kotlinx.coroutines.launch

class ItemViewModel(
    private val itemRepository: ItemRepository
) : ViewModel() {
    private var _items =  mutableListOf<Item>()
    val items: MutableList<Item> = _items

    fun fetchUsers() {
        viewModelScope.launch {
            itemRepository.fetchItems().map { item ->
                items.add(item)
            }
        }
    }
}