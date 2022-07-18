package com.horacek.convertercompose.domain.single_exchange_usecase

import com.horacek.convertercompose.data.repository.CurrencyRepository
import com.horacek.convertercompose.data.response.single_exchange.toCurrencyHolder
import com.horacek.convertercompose.data.util.Resource
import com.horacek.convertercompose.domain.single_exchange_usecase.model.CurrencyHolder
import com.horacek.convertercompose.ui.util.UiText

class GetSingleExchangeUseCase(
    private val repository: CurrencyRepository
) {

    suspend operator fun invoke(currency: String): Resource<CurrencyHolder>{
        return when(val response = repository.getLatestExchange(currency = currency)){
            is Resource.Error -> {
                Resource.Error(message = response.message ?: UiText.unknownError())
            }
            is Resource.Success -> {
                Resource.Success(
                    data = response.data?.toCurrencyHolder()
                )
            }
        }
    }
}