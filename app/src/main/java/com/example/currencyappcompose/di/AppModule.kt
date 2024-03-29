package com.example.currencyappcompose.di

import com.example.currencyappcompose.common.Constants.BASE_URL
import com.example.currencyappcompose.data.remote.CoinPaprikaApi
import com.example.currencyappcompose.data.repository.CoinRepositoryImpl
import com.example.currencyappcompose.domian.repository.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideCoinPaprikaApi():CoinPaprikaApi {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(CoinPaprikaApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCoinRepository(api: CoinPaprikaApi):CoinRepository {
        return CoinRepositoryImpl(api)
    }

}