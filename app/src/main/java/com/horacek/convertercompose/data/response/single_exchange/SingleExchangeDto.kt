package com.horacek.convertercompose.data.response.single_exchange


import com.google.gson.annotations.SerializedName
import com.horacek.convertercompose.ui.model.Currency
import com.horacek.convertercompose.domain.single_exchange_usecase.model.CurrencyHolder

data class SingleExchangeDto(
    @SerializedName("base_code")
    val abbreviation: String,
    @SerializedName("conversion_rates")
    val conversionRates: ConversionRates,
    @SerializedName("documentation")
    val documentation: String,
    @SerializedName("result")
    val result: String,
    @SerializedName("terms_of_use")
    val termsOfUse: String,
    @SerializedName("time_last_update_unix")
    val timeLastUpdateUnix: Int,
    @SerializedName("time_last_update_utc")
    val timeLastUpdateUtc: String,
    @SerializedName("time_next_update_unix")
    val timeNextUpdateUnix: Int,
    @SerializedName("time_next_update_utc")
    val timeNextUpdateUtc: String
)

fun SingleExchangeDto.toCurrencyHolder(): CurrencyHolder? {
    return when(this.abbreviation) {
        "USD" -> CurrencyHolder(
            mainCurrency = Currency.USD(abbreviation = this.abbreviation, value = this.conversionRates.USD),
            conversionsList = this.conversionRates.toCurrencyList()
        )
        "CZK" -> CurrencyHolder(
            mainCurrency = Currency.CZK(abbreviation = this.abbreviation, value = this.conversionRates.CZK),
            conversionsList = this.conversionRates.toCurrencyList()
        )
        "AUD" -> CurrencyHolder(
            mainCurrency = Currency.AUD(abbreviation = this.abbreviation, value = this.conversionRates.AUD),
            conversionsList = this.conversionRates.toCurrencyList()
        )

        "CAD" -> CurrencyHolder(
            mainCurrency = Currency.CAD(abbreviation = this.abbreviation, value = this.conversionRates.CAD),
            conversionsList = this.conversionRates.toCurrencyList()
        )

        "CHF" -> CurrencyHolder(
            mainCurrency = Currency.CHF(abbreviation = this.abbreviation, value = this.conversionRates.CHF),
            conversionsList = this.conversionRates.toCurrencyList()
        )

        "CNY" -> CurrencyHolder(
            mainCurrency = Currency.CNY(abbreviation = this.abbreviation, value = this.conversionRates.CNY),
            conversionsList = this.conversionRates.toCurrencyList()
        )

        "EUR" -> CurrencyHolder(
            mainCurrency = Currency.EUR(abbreviation = this.abbreviation, value = this.conversionRates.EUR),
            conversionsList = this.conversionRates.toCurrencyList()
        )

        "GBP" -> CurrencyHolder(
            mainCurrency = Currency.GBP(abbreviation = this.abbreviation, value = this.conversionRates.GBP),
            conversionsList = this.conversionRates.toCurrencyList()
        )

        "JPY" -> CurrencyHolder(
            mainCurrency = Currency.JPY(abbreviation = this.abbreviation, value = this.conversionRates.JPY),
            conversionsList = this.conversionRates.toCurrencyList()
        )

        "RUB" -> CurrencyHolder(
            mainCurrency = Currency.RUB(abbreviation = this.abbreviation, value = this.conversionRates.RUB),
            conversionsList = this.conversionRates.toCurrencyList()
        )

        "NZD" -> CurrencyHolder(
            mainCurrency = Currency.CHF(abbreviation = this.abbreviation, value = this.conversionRates.NZD),
            conversionsList = this.conversionRates.toCurrencyList()
        )

        else -> null

    }
}
