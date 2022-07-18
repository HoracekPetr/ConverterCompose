package com.horacek.convertercompose.data.remote

import com.horacek.convertercompose.data.response.pair_exchange.PairExchangeDto
import com.horacek.convertercompose.data.response.single_exchange.SingleExchangeDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CurrencyApi {

    @GET("latest/{currency}")
    suspend fun getLatestExchangeRate(@Path("currency") currency: String): SingleExchangeDto

    @GET("pair/{fromCurrency}/{toCurrency}/{amount}")
    suspend fun getPairExchangeRate(
        @Path("fromCurrency") fromCurrency: String,
        @Path("toCurrency") toCurrency: String,
        @Path("amount") amount: Double
    ): PairExchangeDto
}