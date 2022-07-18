package com.horacek.convertercompose.data.response.pair_exchange


import com.google.gson.annotations.SerializedName
import com.horacek.convertercompose.domain.pair_exchange_usecase.model.PairExchangeHolder
import com.horacek.convertercompose.ui.model.Currency

data class PairExchangeDto(
    @SerializedName("base_code")
    val baseCode: String,
    @SerializedName("conversion_rate")
    val conversionRate: Double,
    @SerializedName("conversion_result")
    val conversionResult: Double,
    @SerializedName("documentation")
    val documentation: String,
    @SerializedName("result")
    val result: String,
    @SerializedName("target_code")
    val targetCode: String,
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

fun PairExchangeDto.toPairExchangeHolder(): PairExchangeHolder {
    return PairExchangeHolder(
        baseCode = this.baseCode,
        conversionRate = this.conversionRate,
        conversionResult = this.conversionResult,
        targetCode = this.targetCode
    )
}