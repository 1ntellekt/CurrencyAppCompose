package com.example.currencyappcompose.data.repository

import com.example.currencyappcompose.data.remote.CoinPaprikaApi
import com.example.currencyappcompose.data.remote.dto.CoinDetailDto
import com.example.currencyappcompose.data.remote.dto.CoinDto
import com.example.currencyappcompose.domian.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
   private val api: CoinPaprikaApi
):CoinRepository {

    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId)
    }

}