package com.fetch.application.ui.viewmodel

import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fetch.application.data.ItemModel
import com.fetch.application.data.repository.ItemRepository
import com.fetch.application.domain.FetchItemsUseCase
import com.fetch.application.ui.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ItemViewModel(
    private val fetchItemsUseCase: FetchItemsUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<UiState<List<ItemModel>>>(UiState.Loading)
    val uiState = _uiState.asStateFlow()

    init {
        fetchItems(1)
    }

    fun fetchItems(listId: Int) {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            _uiState.value = fetchItemsUseCase(listId)
        }
    }

    fun refresh(listId: Int) {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            _uiState.value = fetchItemsUseCase.refresh(listId)
        }
    }
}