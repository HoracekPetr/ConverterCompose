package com.horacek.convertercompose.di

import com.horacek.convertercompose.data.remote.CurrencyApi
import com.horacek.convertercompose.data.repository.CurrencyRepository
import com.horacek.convertercompose.data.repository.CurrencyRepositoryImpl
import com.horacek.convertercompose.data.util.Constants.BASE_URL
import com.horacek.convertercompose.domain.single_exchange_usecase.GetSingleExchangeUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CurrencyModule {

    @Provides
    @Singleton
    fun provideCurrencyApi(): CurrencyApi{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CurrencyApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCurrencyRepository(api: CurrencyApi): CurrencyRepository{
        return CurrencyRepositoryImpl(api = api)
    }

    @Provides
    @Singleton
    fun provideSingleExchangeUseCase(repository: CurrencyRepository): GetSingleExchangeUseCase{
        return GetSingleExchangeUseCase(repository = repository)
    }
}