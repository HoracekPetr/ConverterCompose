package com.horacek.convertercompose.data.response.single_exchange


import com.google.gson.annotations.SerializedName
import com.horacek.convertercompose.ui.model.Currency

data class ConversionRates(
    @SerializedName("AUD")
    val AUD: Double,
    @SerializedName("CAD")
    val CAD: Double,
    @SerializedName("CZK")
    val CZK: Double,
    @SerializedName("NZD")
    val NZD: Double,
    @SerializedName("USD")
    val USD: Double,
    @SerializedName("CHF")
    val CHF: Double,
    @SerializedName("CNY")
    val CNY: Double,
    @SerializedName("EUR")
    val EUR: Double,
    @SerializedName("GBP")
    val GBP: Double,
    @SerializedName("JPY")
    val JPY: Double,
    @SerializedName("RUB")
    val RUB: Double,
)

fun ConversionRates.toCurrencyList(): List<Currency?>{
    val properties = this::class.members

    val currencyList = properties.map { property ->
        when(property.name){
            "AUD" -> Currency.AUD(abbreviation = property.name, value = this.AUD)
            "CAD" -> Currency.CAD(abbreviation = property.name, value = this.CAD)
            "CZK" -> Currency.CZK(abbreviation = property.name, value = this.CZK)
            "NZD" -> Currency.NZD(abbreviation = property.name, value = this.NZD)
            "USD" -> Currency.USD(abbreviation = property.name, value = this.USD)
            "CHF" -> Currency.CHF(abbreviation = property.name, value = this.CHF)
            "CNY" -> Currency.CNY(abbreviation = property.name, value = this.CNY)
            "EUR" -> Currency.EUR(abbreviation = property.name, value = this.EUR)
            "GBP" -> Currency.GBP(abbreviation = property.name, value = this.GBP)
            "JPY" -> Currency.JPY(abbreviation = property.name, value = this.JPY)
            "RUB" -> Currency.RUB(abbreviation = property.name, value = this.RUB)
            else -> null
        }
    }

    return currencyList
}
