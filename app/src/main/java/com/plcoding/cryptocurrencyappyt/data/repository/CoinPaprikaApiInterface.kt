package com.plcoding.cryptocurrencyappyt.data.repository

import CoinDetailDto
import com.plcoding.cryptocurrencyappyt.data.dto.CoinDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinPaprikaApiInterface {
    @GET("/v1/coins")
    suspend fun getCoins(): List<CoinDto>

    @GET("/v1/coins/{coinId}")
    suspend fun getCoinsById(@Path("coinId") coinId: String) : CoinDetailDto
}