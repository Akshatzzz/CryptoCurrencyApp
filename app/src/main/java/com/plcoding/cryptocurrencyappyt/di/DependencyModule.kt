package com.plcoding.cryptocurrencyappyt.di

import android.app.Application
import com.plcoding.cryptocurrencyappyt.common.BASE_URL
import com.plcoding.cryptocurrencyappyt.data.repository.CoinPaprikaApiInterface
import com.plcoding.cryptocurrencyappyt.data.repository.CoinsRepositoryImpl
import com.plcoding.cryptocurrencyappyt.domain.repository.CoinsRepository
import com.plcoding.cryptocurrencyappyt.domain.use_cases.CoinUseCase
import com.plcoding.cryptocurrencyappyt.domain.use_cases.get_coin.GetCoinDetailUseCase
import com.plcoding.cryptocurrencyappyt.domain.use_cases.get_coins.GetAllCoinsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DependencyModule {
    @Provides
    @Singleton
    fun provideRetrofitForApi(app:Application): CoinPaprikaApiInterface {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinPaprikaApiInterface::class.java)
    }
    @Provides
    @Singleton
    fun provideCoinsRepository(coinPaprikaApiInterface: CoinPaprikaApiInterface) : CoinsRepository {
        return CoinsRepositoryImpl(coinPaprikaApiInterface)
    }
    @Provides
    @Singleton
    fun provideUseCases(coinsRepository: CoinsRepository): CoinUseCase {
        return CoinUseCase(
            GetAllCoinsUseCase(coinsRepository),
            GetCoinDetailUseCase(coinsRepository)
        )
    }
}