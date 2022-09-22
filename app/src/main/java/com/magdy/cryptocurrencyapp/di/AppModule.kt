package com.magdy.cryptocurrencyapp.di

import com.magdy.cryptocurrencyapp.common.Constant
import com.magdy.cryptocurrencyapp.data.remote.CoinApi
import com.magdy.cryptocurrencyapp.data.repository.CoinRepositoryImpl
import com.magdy.cryptocurrencyapp.domin.repository.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideApi(): CoinApi = Retrofit.Builder()
        .baseUrl(Constant.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(CoinApi::class.java)

    @Provides
    @Singleton
    fun provideRepository(api:CoinApi):CoinRepository{
        return CoinRepositoryImpl(api)
    }
}