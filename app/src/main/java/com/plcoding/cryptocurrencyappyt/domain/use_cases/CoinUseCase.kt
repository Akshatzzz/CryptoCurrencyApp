package com.plcoding.cryptocurrencyappyt.domain.use_cases

import com.plcoding.cryptocurrencyappyt.domain.use_cases.get_coin.GetCoinDetailUseCase
import com.plcoding.cryptocurrencyappyt.domain.use_cases.get_coins.GetAllCoinsUseCase

data class CoinUseCase(
    val getAllCoinsUseCase: GetAllCoinsUseCase,
    val getCoinDetailUseCase: GetCoinDetailUseCase
)
