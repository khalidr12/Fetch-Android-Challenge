package com.fetch.application.api

import retrofit2.http.GET

interface ItemAPIService {
    @GET("hiring.json")
    suspend fun getItems(): List<Item>
}