package com.magdy.cryptocurrencyapp.presentation.ui.coin_details

import com.magdy.cryptocurrencyapp.domin.model.Coin
import com.magdy.cryptocurrencyapp.domin.model.CoinDetail

data class CoinDetailState(
    val isLoading:Boolean=false,
    val coin:CoinDetail?=null ,
    val errorMessage:String=""
)