package com.fetch.application.ui

sealed class UiState<out T> {
    object Loading : UiState<Nothing>()
    data class Loaded<T>(val data: T) : UiState<T>()
    data class Error(val exception: Exception) : UiState<Nothing>()
}