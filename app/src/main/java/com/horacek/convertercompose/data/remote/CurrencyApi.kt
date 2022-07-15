package com.horacek.convertercompose.data.remote

import com.horacek.convertercompose.data.response.CurrencyDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CurrencyApi {

    @GET("{currency}")
    suspend fun getLatestExchangeRate(@Path("currency") currency: String): CurrencyDto
}