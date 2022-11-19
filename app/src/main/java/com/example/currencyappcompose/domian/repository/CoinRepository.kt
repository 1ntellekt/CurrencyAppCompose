package com.example.currencyappcompose.domian.repository

import com.example.currencyappcompose.data.remote.dto.CoinDetailDto
import com.example.currencyappcompose.data.remote.dto.CoinDto

interface CoinRepository {

    suspend fun getCoins():List<CoinDto>

    suspend fun getCoinById(coinId:String):CoinDetailDto

}