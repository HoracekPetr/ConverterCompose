package com.horacek.convertercompose.domain.single_exchange_usecase.model

data class CurrencyHolder(
    val mainCurrency: Currency? = null,
    val conversionsList: List<Currency?>? = null
)
