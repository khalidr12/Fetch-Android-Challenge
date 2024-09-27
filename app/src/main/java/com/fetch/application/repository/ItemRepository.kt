package com.fetch.application.repository

import com.fetch.application.api.Item

interface ItemRepository {
    suspend fun fetchItems(): List<Item>
}