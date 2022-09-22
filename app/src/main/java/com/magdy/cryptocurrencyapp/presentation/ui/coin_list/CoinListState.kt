package com.magdy.cryptocurrencyapp.presentation.ui.coin_list

import com.magdy.cryptocurrencyapp.domin.model.Coin

data class CoinListState(
    val isLoading:Boolean=false,
    val coinsList:List<Coin> = emptyList(),
    val errorMessage:String=""
)