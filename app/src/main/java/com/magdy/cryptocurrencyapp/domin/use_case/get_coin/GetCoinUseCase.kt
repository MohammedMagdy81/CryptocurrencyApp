package com.magdy.cryptocurrencyapp.domin.use_case.get_coin

import com.magdy.cryptocurrencyapp.common.Resource
import com.magdy.cryptocurrencyapp.data.remote.dto.toCoin
import com.magdy.cryptocurrencyapp.data.remote.dto.toCoinDetail
import com.magdy.cryptocurrencyapp.domin.model.Coin
import com.magdy.cryptocurrencyapp.domin.model.CoinDetail
import com.magdy.cryptocurrencyapp.domin.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {

    operator fun invoke(coinId:String): Flow<Resource<CoinDetail>> = flow {

        try {
            emit(Resource.Loading())
            val coin= repository.getCoinById(coinId).toCoinDetail()
            emit(Resource.Success<CoinDetail>(coin))
        }catch (e:HttpException){
            emit(Resource.Error<CoinDetail>(e.localizedMessage?:"Un expected Error !"))
        }catch (e:IOException){
            emit(Resource.Error<CoinDetail>("Check Internet Connection !"))
        }
    }

}

