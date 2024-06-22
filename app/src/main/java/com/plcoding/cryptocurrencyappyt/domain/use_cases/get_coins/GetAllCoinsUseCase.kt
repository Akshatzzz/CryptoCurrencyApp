package com.plcoding.cryptocurrencyappyt.domain.use_cases.get_coins

import com.plcoding.cryptocurrencyappyt.domain.model.Coins
import com.plcoding.cryptocurrencyappyt.domain.repository.CoinsRepository

class GetAllCoinsUseCase(
    private val coinsRepository: CoinsRepository
) {
    suspend operator fun invoke(): List<Coins> {
        return coinsRepository.getCoinsList()
    }
}