package com.horacek.convertercompose.data.response


import com.google.gson.annotations.SerializedName
import com.horacek.convertercompose.domain.single_exchange_usecase.model.Currency
import com.horacek.convertercompose.domain.single_exchange_usecase.model.CurrencyHolder

data class CurrencyDto(
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

fun CurrencyDto.toCurrencyHolder(): CurrencyHolder {
    return when(this.abbreviation) {
        "USD" -> CurrencyHolder(
            mainCurrency = Currency.USD(abbreviation = this.abbreviation, value = this.conversionRates.USD),
            conversionsList = this.conversionRates.toCurrencyList()
        )
        else -> CurrencyHolder(
            mainCurrency = Currency.CZK(abbreviation = this.abbreviation, value = this.conversionRates.CZK),
            conversionsList = this.conversionRates.toCurrencyList()
        )
    }
}
