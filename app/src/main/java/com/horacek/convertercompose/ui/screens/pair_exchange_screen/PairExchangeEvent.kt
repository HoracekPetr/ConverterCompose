package com.horacek.convertercompose.ui.screens.pair_exchange_screen

sealed class PairExchangeEvent{
    data class ConvertButtonClicked(
        val fromCurrencyAbbreviation: String,
        val toCurrencyAbbreviation: String,
        val amount: Double
    ): PairExchangeEvent()

    data class EnteredAmountText(
        val amount: String
    ): PairExchangeEvent()
}
