package com.horacek.convertercompose.ui.screens.pair_exchange_screen

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.horacek.convertercompose.data.util.Resource
import com.horacek.convertercompose.domain.pair_exchange_usecase.GetPairExchangeUseCase
import com.horacek.convertercompose.domain.pair_exchange_usecase.model.PairExchangeHolder
import com.horacek.convertercompose.ui.model.Currency
import com.horacek.convertercompose.ui.screens.pair_exchange_screen.states.AmountTextFieldState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PairExchangeViewModel @Inject constructor(
    private val getPairExchangeUseCase: GetPairExchangeUseCase
) : ViewModel() {

    private val _isLoading = mutableStateOf(false)
    val isLoading = _isLoading

    private val _pairExchangeHolder = mutableStateOf(PairExchangeHolder())
    val pairExchangeHolder = _pairExchangeHolder

    private val _amountTextfieldState = mutableStateOf(AmountTextFieldState())
    val amountTextFieldState = _amountTextfieldState

    private val _fromCurrency = mutableStateOf<Currency?>(Currency.USD(abbreviation = "USD"))
    val fromCurrency = _fromCurrency

    private val _toCurrency = mutableStateOf<Currency?>(Currency.GBP(abbreviation = "GBP"))
    val toCurrency = _toCurrency

    private val _resultText = mutableStateOf<String?>(null)
    val resultText = _resultText

    fun onEvent(event: PairExchangeEvent) {
        when (event) {
            is PairExchangeEvent.ConvertButtonClicked -> {

                viewModelScope.launch {
                    getPairExchange(
                        fromCurrency = event.fromCurrencyAbbreviation,
                        toCurrency = event.toCurrencyAbbreviation,
                        amount = event.amount
                    )
                }
            }
            is PairExchangeEvent.EnteredAmountText -> {
                _amountTextfieldState.value = _amountTextfieldState.value.copy(
                    text = event.amount
                )
            }
        }
    }

    private suspend fun getPairExchange(
        fromCurrency: String,
        toCurrency: String,
        amount: Double
    ) {
        _isLoading.value = true

        when (val response = getPairExchangeUseCase(
            fromCurrency = fromCurrency,
            toCurrency = toCurrency,
            amount = amount
        )) {
            is Resource.Error -> {
                _isLoading.value = false
            }
            is Resource.Success -> {
                _pairExchangeHolder.value = _pairExchangeHolder.value.copy(
                    baseCode = response.data?.baseCode,
                    conversionRate = response.data?.conversionRate,
                    conversionResult = response.data?.conversionResult,
                    targetCode = response.data?.targetCode,
                )

                _resultText.value =
                    "${_amountTextfieldState.value.text} ${_pairExchangeHolder.value.baseCode} = ${_pairExchangeHolder.value.conversionResult} ${_pairExchangeHolder.value.targetCode}"

                _isLoading.value = false
            }
        }
    }

}