package com.fetch.application.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ItemDao {
    @Query("SELECT * FROM items WHERE listId = :listId")
    suspend fun getItemsByListId(listId: Int): List<Item>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertItems(items: List<Item>)

    @Query("DELETE FROM items")
    suspend fun clearItems()
}