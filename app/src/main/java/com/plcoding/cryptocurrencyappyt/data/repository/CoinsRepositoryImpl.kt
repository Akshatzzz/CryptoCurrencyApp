package com.plcoding.cryptocurrencyappyt.data.repository

import com.plcoding.cryptocurrencyappyt.data.dto.getCoin
import com.plcoding.cryptocurrencyappyt.domain.model.Coins
import com.plcoding.cryptocurrencyappyt.domain.model.CoinDetail
import com.plcoding.cryptocurrencyappyt.domain.repository.CoinsRepository
import getCoinDetail
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CoinsRepositoryImpl(private val coinPeprikaPaprikaApiInterface: CoinPaprikaApiInterface) :
    CoinsRepository {
    override suspend fun getCoinsList(): List<Coins> = withContext(Dispatchers.Default){
        return@withContext coinPeprikaPaprikaApiInterface.getCoins().map {
            it.getCoin()
        }
    }

    override suspend fun getCoinDetailById(coinId: String): CoinDetail = withContext(Dispatchers.Default){
        return@withContext coinPeprikaPaprikaApiInterface.getCoinsById(coinId).getCoinDetail()
    }
}