package com.magdy.cryptocurrencyapp.domin.repository

import com.magdy.cryptocurrencyapp.data.remote.dto.CoinDetailDto
import com.magdy.cryptocurrencyapp.data.remote.dto.CoinDto

interface CoinRepository {

    suspend fun getCoins():List<CoinDto>

    suspend fun getCoinById(coinId:String):CoinDetailDto
}