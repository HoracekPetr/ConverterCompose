package com.horacek.convertercompose.domain.pair_exchange_usecase

import com.horacek.convertercompose.data.repository.CurrencyRepository
import com.horacek.convertercompose.data.response.pair_exchange.toPairExchangeHolder
import com.horacek.convertercompose.data.util.Resource
import com.horacek.convertercompose.domain.pair_exchange_usecase.model.PairExchangeHolder
import com.horacek.convertercompose.ui.util.UiText

class GetPairExchangeUseCase(
    private val repository: CurrencyRepository
) {

    suspend operator fun invoke(
        fromCurrency: String,
        toCurrency: String,
        amount: Double
    ): Resource<PairExchangeHolder> {
        return when (val pairResult = repository.getPairExchange(
            fromCurrency = fromCurrency,
            toCurrency = toCurrency,
            amount = amount
        )) {
            is Resource.Error -> {
                Resource.Error(
                    message = pairResult.message ?: UiText.unknownError()
                )
            }
            is Resource.Success -> {
                Resource.Success(
                    data = pairResult.data?.toPairExchangeHolder()
                )
            }
        }
    }
}