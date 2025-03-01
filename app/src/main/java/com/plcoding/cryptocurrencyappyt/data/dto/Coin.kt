package com.plcoding.cryptocurrencyappyt.data.dto

import com.google.gson.annotations.SerializedName
import com.plcoding.cryptocurrencyappyt.domain.model.Coins

data class CoinDto(
    val id: String,
    @SerializedName("is_active")
    val isActive: Boolean,
    @SerializedName("is_new")
    val isNew: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
    val type: String
)

fun CoinDto.getCoin(): Coins {
    return Coins(
        id = id,
        isActive = isActive,
        name = name,
        rank = rank,
        symbol = symbol
    )
}