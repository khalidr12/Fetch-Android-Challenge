package com.fetch.application.di

import com.fetch.application.api.ItemAPIService
import com.fetch.application.repository.ItemRepository
import com.fetch.application.repository.ItemRepositoryImpl
import com.fetch.application.ui.viewmodel.ItemViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module {
    single { createRetrofit() }
    single { get<Retrofit>().create(ItemAPIService::class.java) }
    single<ItemRepository> { ItemRepositoryImpl(get()) }
    viewModel { ItemViewModel(get()) }
}

fun createRetrofit(): Retrofit {
    return Retrofit.Builder()
        .baseUrl("https://fetch-hiring.s3.amazonaws.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}