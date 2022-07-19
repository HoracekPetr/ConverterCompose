package com.horacek.convertercompose.ui.screens.pair_exchange_screen

import com.horacek.convertercompose.ui.components.PickedCurrency
import com.horacek.convertercompose.ui.model.Currency

sealed class PairExchangeEvent{
    data class ConvertButtonClicked(
        val fromCurrencyAbbreviation: String,
        val toCurrencyAbbreviation: String,
        val amount: Double
    ): PairExchangeEvent()

    data class EnteredAmountText(
        val amount: String
    ): PairExchangeEvent()

    object ChangeDialogOpenStatus: PairExchangeEvent()

    data class ChangePickedCurrency(val pickedCurrency: PickedCurrency): PairExchangeEvent()

    data class ChangeCurrency(val pickedCurrency: PickedCurrency, val currency: Currency): PairExchangeEvent()
}
