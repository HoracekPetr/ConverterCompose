package com.horacek.convertercompose.ui.screens.single_exchange_screen

sealed class SingleExchangeEvent{
    class ChangedCurrency(val currency: String): SingleExchangeEvent()
}
