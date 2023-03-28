package com.yacahya.note_app_compose.feature.domain.util

sealed class OrderType {
    object Ascending: OrderType()
    object Descending: OrderType()
}
