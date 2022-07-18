package com.horacek.convertercompose.domain.single_exchange_usecase.model

import com.horacek.convertercompose.ui.model.Currency

data class CurrencyHolder(
    val mainCurrency: Currency? = null,
    val conversionsList: List<Currency?>? = null
)
