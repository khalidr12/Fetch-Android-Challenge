package com.fetch.application.di

import androidx.room.Room
import com.fetch.application.data.api.ItemAPIService
import com.fetch.application.data.repository.ItemRepository
import com.fetch.application.data.repository.ItemRepositoryImpl
import com.fetch.application.data.room.AppDatabase
import com.fetch.application.domain.FetchItemsUseCase
import com.fetch.application.ui.viewmodel.ItemViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module {
    single {
        Room.databaseBuilder(
            androidContext(),
            AppDatabase::class.java,
            "app_database"
        ).build()
    }
    single { get<AppDatabase>().itemDao() }
    single { createRetrofit() }
    single { get<Retrofit>().create(ItemAPIService::class.java) }
    single { FetchItemsUseCase(get()) }
    single<ItemRepository> { ItemRepositoryImpl(get(), get()) }
    viewModel { ItemViewModel(get()) }
}

fun createRetrofit(): Retrofit {
    return Retrofit.Builder()
        .baseUrl("https://fetch-hiring.s3.amazonaws.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}