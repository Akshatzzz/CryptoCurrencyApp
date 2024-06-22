package com.plcoding.cryptocurrencyappyt.presentation.coin_list.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.plcoding.cryptocurrencyappyt.domain.util.CoinEvents
import com.plcoding.cryptocurrencyappyt.presentation.coin_list.view_model.CoinsListViewModel

@Composable
fun CoinsListScreen(
    coinsListViewModel: CoinsListViewModel = hiltViewModel(),
) {
    coinsListViewModel.onEvent(CoinEvents.ScreenOpenEvent)
    val state = coinsListViewModel.state
    LazyColumn(
        modifier = Modifier.fillMaxWidth()
    ) {
        items(state.value) {
            Row {
                Text(text = it.name)
                Text(text = it.symbol)
                Text(text = it.rank.toString())
            }
        }
    }
}