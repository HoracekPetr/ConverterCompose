package com.horacek.convertercompose.data.repository

import com.horacek.convertercompose.R
import com.horacek.convertercompose.data.remote.CurrencyApi
import com.horacek.convertercompose.data.response.ApiResult
import com.horacek.convertercompose.data.response.CurrencyDto
import com.horacek.convertercompose.data.util.Resource
import com.horacek.convertercompose.ui.util.UiText
import retrofit2.HttpException
import java.io.IOException

class CurrencyRepositoryImpl(
    private val api: CurrencyApi
): CurrencyRepository {

    override suspend fun getLatestExchange(currency: String): Resource<CurrencyDto> {
        return try {
            val exchangeResponse = api.getLatestExchangeRate(currency = currency)

            if(exchangeResponse.result == ApiResult.Success.result){
                Resource.Success(data = exchangeResponse)
            } else {
                Resource.Error(message = UiText.StringResource(R.string.cant_load_currency))
            }
        } catch (e: HttpException) {
            Resource.Error(message = UiText.StringResource(R.string.an_unknown_error_occured))
        } catch (e: IOException) {
            Resource.Error(message = UiText.StringResource(R.string.cant_reach_server))
        }
    }
}