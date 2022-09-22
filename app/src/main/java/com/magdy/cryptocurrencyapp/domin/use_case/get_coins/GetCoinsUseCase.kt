package com.magdy.cryptocurrencyapp.domin.use_case.get_coins

import com.magdy.cryptocurrencyapp.common.Resource
import com.magdy.cryptocurrencyapp.data.remote.dto.toCoin
import com.magdy.cryptocurrencyapp.domin.model.Coin
import com.magdy.cryptocurrencyapp.domin.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
) {

    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading<List<Coin>>())
            val coins = repository.getCoins().map {
                it.toCoin()
            }
            emit(Resource.Success<List<Coin>>(coins))
        } catch (e: HttpException) {
                emit(Resource.Error<List<Coin>>(e.localizedMessage?:"Un expected Error !"))
        } catch (e: IOException) {
            emit(Resource.Error<List<Coin>>("Check Internet Connection !"))
        }
    }

}

