package com.horacek.convertercompose.domain.pair_exchange_usecase.model

data class PairExchangeHolder(
    val baseCode: String? = null,
    val conversionRate: Double? = null,
    val conversionResult: Double? = null,
    val targetCode: String? = null
)
