package com.horacek.convertercompose.data.repository

import com.horacek.convertercompose.data.response.CurrencyDto
import com.horacek.convertercompose.data.util.Resource

interface CurrencyRepository {

    suspend fun getLatestExchange(currency: String): Resource<CurrencyDto>

}