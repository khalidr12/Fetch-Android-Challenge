package com.fetch.application.data.api

import com.fetch.application.data.room.Item
import retrofit2.http.GET

interface ItemAPIService {
    @GET("hiring.json")
    suspend fun getItems(): List<Item>
}