package com.plcoding.cryptocurrencyappyt.domain.repository

import com.plcoding.cryptocurrencyappyt.domain.model.Coins
import com.plcoding.cryptocurrencyappyt.domain.model.CoinDetail

interface CoinsRepository {
    suspend fun getCoinsList(): List<Coins>

    suspend fun getCoinDetailById(coinId: String): CoinDetail
}