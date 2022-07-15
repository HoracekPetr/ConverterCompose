package com.horacek.convertercompose.data.response


import com.google.gson.annotations.SerializedName
import com.horacek.convertercompose.domain.single_exchange_usecase.model.Currency

data class ConversionRates(
    @SerializedName("AUD")
    val AUD: Double,
    @SerializedName("CAD")
    val CAD: Double,
    @SerializedName("CZK")
    val CZK: Double,
    @SerializedName("NZD")
    val NZD: Double,
    @SerializedName("PLN")
    val PLN: Double,
    @SerializedName("USD")
    val USD: Double,
)

fun ConversionRates.toCurrencyList(): List<Currency?>{
    val properties = this::class.members

    val currencyList = properties.map { property ->
        when(property.name){
            "USD" -> Currency.USD(abbreviation = property.name, value = this.USD)
            "CZK" -> Currency.CZK(abbreviation = property.name, value = this.CZK)
            "AUD" -> Currency.AUD(abbreviation = property.name, value = this.AUD)
            "CAD" -> Currency.CAD(abbreviation = property.name, value = this.CAD)
            else -> null
        }
    }

    return currencyList
}
