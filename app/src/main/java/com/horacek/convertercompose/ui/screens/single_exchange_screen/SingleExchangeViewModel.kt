package com.horacek.convertercompose.ui.screens.single_exchange_screen

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.horacek.convertercompose.data.util.Resource
import com.horacek.convertercompose.domain.single_exchange_usecase.GetSingleExchangeUseCase
import com.horacek.convertercompose.domain.single_exchange_usecase.model.CurrencyHolder
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SingleExchangeViewModel @Inject constructor(
    private val getSingleExchangeUseCase: GetSingleExchangeUseCase
): ViewModel() {

    private val _isLoading = mutableStateOf(false)
    val isLoading = _isLoading

    private val _currencyHolder = mutableStateOf(CurrencyHolder())
    val currencyHolder = _currencyHolder

    init {
        viewModelScope.launch {
            getSingleExchange("AUD")
        }
    }

    private suspend fun getSingleExchange(currency: String){

        _isLoading.value = true

        when(val response = getSingleExchangeUseCase(currency)){
            is Resource.Error -> {
                println("ERROR LOADING RATEs")
                _isLoading.value = false
            }
            is Resource.Success -> {
                _currencyHolder.value = _currencyHolder.value.copy(
                    mainCurrency = response.data?.mainCurrency,
                    conversionsList = response.data?.conversionsList
                )

                _isLoading.value = false
            }
        }
    }

}