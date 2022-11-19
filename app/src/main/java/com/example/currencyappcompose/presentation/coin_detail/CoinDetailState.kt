package com.example.currencyappcompose.presentation.coin_detail

import com.example.currencyappcompose.domian.entity.CoinDetail

data class CoinDetailState(
    val isLoading:Boolean = false,
    val coinDetail: CoinDetail? = null,
    val error:String = ""
)