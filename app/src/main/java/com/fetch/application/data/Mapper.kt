package com.fetch.application.data

import com.fetch.application.data.room.Item

fun Item.toModel() : ItemModel {
    return ItemModel(
        name = this.name,
        id = this.id,
        listId = this.listId
    )
}