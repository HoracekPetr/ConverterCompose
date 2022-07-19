package com.horacek.convertercompose.ui.model

import com.horacek.convertercompose.R

sealed class Currency(
    val abbreviation: String,
    val fullName: String,
    val flagResourceId: Int,
    val sign: String,
    val value: Double? = 1.0
) {
    class USD(
        abbreviation: String = "USD",
        value: Double? = null
    ): Currency(
        abbreviation = abbreviation,
        fullName = "American Dollar",
        flagResourceId = R.drawable.us_flag,
        sign="$",
        value = value
    )

    class CZK(
        abbreviation: String = "CZK",
        value: Double? = null
    ): Currency(
        abbreviation = abbreviation,
        fullName = "Czech Koruna",
        flagResourceId = R.drawable.cz_flag,
        sign="Kč",
        value = value
    )

    class AUD(
        abbreviation: String = "AUD",
        value: Double? = null
    ): Currency(
        abbreviation = abbreviation,
        fullName = "Australian Dollar",
        flagResourceId = R.drawable.au_flag,
        sign="$",
        value = value
    )

    class CAD(
        abbreviation: String = "CAD",
        value: Double? = null
    ): Currency(
        abbreviation = abbreviation,
        fullName = "Canadian Dollar",
        flagResourceId = R.drawable.cad_flag,
        sign="$",
        value = value
    )

    class CHF(
        abbreviation: String = "CHF",
        value: Double? = null
    ): Currency(
        abbreviation = abbreviation,
        fullName = "Swiss Franc",
        flagResourceId = R.drawable.ch_flag,
        sign = "CHF",
        value = value
    )

    class CNY(
        abbreviation: String = "CNY",
        value: Double? = null
    ): Currency(
        abbreviation = abbreviation,
        fullName = "Chinese Yuan",
        flagResourceId = R.drawable.cn_flag,
        sign = "¥",
        value = value
    )

    class EUR(
        abbreviation: String = "EUR",
        value: Double? = null
    ): Currency(
        abbreviation = abbreviation,
        fullName = "Euro",
        flagResourceId = R.drawable.eu_flag,
        sign = "€",
        value = value
    )

    class GBP(
        abbreviation: String = "GBP",
        value: Double? = null
    ): Currency(
        abbreviation = abbreviation,
        fullName = "British Pound",
        flagResourceId = R.drawable.uk_flag,
        sign = "£",
        value = value
    )

    class JPY(
        abbreviation: String = "JPY",
        value: Double? = null
    ): Currency(
        abbreviation = abbreviation,
        fullName = "Japanese Yen",
        flagResourceId = R.drawable.jp_flag,
        sign = "¥",
        value = value
    )

    class RUB(
        abbreviation: String = "RUB",
        value: Double? = null
    ): Currency(
        abbreviation = abbreviation,
        fullName = "Russian Ruble",
        flagResourceId = R.drawable.ru_flag,
        sign = "₽",
        value = value
    )

    class NZD(
        abbreviation: String = "NZD",
        value: Double? = null
    ): Currency(
        abbreviation = abbreviation,
        fullName = "New Zealand Dollar",
        flagResourceId = R.drawable.nz_flag,
        sign = "$",
        value = value
    )

    companion object{
        fun getAllCurrencies(): List<Currency>{
            return listOf(
                AUD(), RUB(), USD(), CZK(),
                CAD(), CHF(), CNY(), EUR(),
                GBP(), JPY(), NZD()
            )
        }
    }
}

