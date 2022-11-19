package com.example.currencyappcompose.domian.usecases.get_coins

import com.example.currencyappcompose.common.Resource
import com.example.currencyappcompose.data.remote.dto.toCoin
import com.example.currencyappcompose.domian.entity.Coin
import com.example.currencyappcompose.domian.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
) {

    operator fun invoke():Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading())
            val coins = repository.getCoins().map { it.toCoin() }
            emit(Resource.Success(coins))
        } catch (e:HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occured"))
        } catch (e:IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection"))
        }

    }

}