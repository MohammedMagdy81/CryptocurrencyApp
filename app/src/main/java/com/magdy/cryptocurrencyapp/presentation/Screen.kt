package com.magdy.cryptocurrencyapp.presentation

import com.magdy.cryptocurrencyapp.common.Constant

sealed class Screen(val route :String){

    object CoinListScreen:Screen(Constant.COIN_LIST_SCREEN)
    object CoinDetailScreen:Screen(Constant.COIN_DETAIL_SCREEN)
}
