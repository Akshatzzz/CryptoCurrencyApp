package com.plcoding.cryptocurrencyappyt.presentation.coin_list.view_model

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.plcoding.cryptocurrencyappyt.domain.model.Coins
import com.plcoding.cryptocurrencyappyt.domain.use_cases.CoinUseCase
import com.plcoding.cryptocurrencyappyt.domain.util.CoinEvents
import androidx.compose.runtime.State
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CoinsListViewModel @Inject constructor(private val coinsUseCase: CoinUseCase) : ViewModel() {
    private val _state = mutableStateOf(emptyList<Coins>())
    val state: State<List<Coins>> = _state
    fun onEvent(coinEvent: CoinEvents) {
        if(coinEvent is CoinEvents.ScreenOpenEvent) {
            viewModelScope.launch{ _state.value = coinsUseCase.getAllCoinsUseCase.invoke() }
        }
    }
}