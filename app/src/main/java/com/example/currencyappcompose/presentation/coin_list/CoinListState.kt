package com.example.currencyappcompose.presentation.coin_list

import com.example.currencyappcompose.domian.entity.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)
