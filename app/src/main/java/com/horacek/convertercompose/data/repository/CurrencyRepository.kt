package com.horacek.convertercompose.data.repository

import com.horacek.convertercompose.data.response.pair_exchange.PairExchangeDto
import com.horacek.convertercompose.data.response.single_exchange.SingleExchangeDto
import com.horacek.convertercompose.data.util.Resource

interface CurrencyRepository {

    suspend fun getLatestExchange(currency: String): Resource<SingleExchangeDto>

    suspend fun getPairExchange(
        fromCurrency: String,
        toCurrency: String,
        amount: Double
    ): Resource<PairExchangeDto>

}