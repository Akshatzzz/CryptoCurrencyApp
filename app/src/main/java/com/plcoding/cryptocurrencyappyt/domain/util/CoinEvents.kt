package com.plcoding.cryptocurrencyappyt.domain.util

sealed class CoinEvents {
    object ScreenOpenEvent : CoinEvents()

    data class ShowDetailEvent(val coinId: String): CoinEvents()
}