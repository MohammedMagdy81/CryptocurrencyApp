package com.magdy.cryptocurrencyapp.data.repository

import com.magdy.cryptocurrencyapp.data.remote.CoinApi
import com.magdy.cryptocurrencyapp.data.remote.dto.CoinDetailDto
import com.magdy.cryptocurrencyapp.data.remote.dto.CoinDto
import com.magdy.cryptocurrencyapp.domin.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api :CoinApi
):CoinRepository {
    override suspend fun getCoins(): List<CoinDto> {
       return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
       return api.getCoinById(coinId)
    }
}