package com.fetch.application.data

data class Items(
    val itemModels: List<ItemModel>
)

data class ItemModel(
    val id : Int,
    val listId: Int,
    val name: String?
)