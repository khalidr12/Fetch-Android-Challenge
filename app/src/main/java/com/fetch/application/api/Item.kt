package com.fetch.application.api

data class Items(
    val items: List<Item>
)

data class Item(
    val id : Int,
    val listId: Int,
    val name: String?
)