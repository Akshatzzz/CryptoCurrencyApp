package com.plcoding.cryptocurrencyappyt.domain.use_cases.get_coin

import com.plcoding.cryptocurrencyappyt.domain.model.CoinDetail
import com.plcoding.cryptocurrencyappyt.domain.repository.CoinsRepository

class GetCoinDetailUseCase(private val coinsRepository: CoinsRepository) {
    suspend operator fun invoke(coinId: String): CoinDetail {
        return coinsRepository.getCoinDetailById(coinId)
    }
}