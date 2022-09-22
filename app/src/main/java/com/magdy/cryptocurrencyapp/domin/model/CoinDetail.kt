package com.magdy.cryptocurrencyapp.domin.model

import com.magdy.cryptocurrencyapp.data.remote.dto.TeamMember

data class CoinDetail(
    val coinId:String,
    val name:String,
    val description:String,
    val rank:Int,
    val symbol:String,
    val tags:List<String>,
    val isActive:Boolean,
    val team:List<TeamMember>,

)