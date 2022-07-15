package com.horacek.convertercompose.domain.single_exchange_usecase.model

import com.horacek.convertercompose.R

sealed class Currency(
    val abbreviation: String,
    val fullName: String,
    val flagResourceId: Int,
    val sign: String,
    val value: Double = 1.0
) {
    class USD(
        abbreviation: String,
        value: Double
    ): Currency(
        abbreviation = abbreviation,
        fullName = "American Dollar",
        flagResourceId = R.drawable.us_flag,
        sign="$",
        value = value
    )

    class CZK(
        abbreviation: String,
        value: Double
    ): Currency(
        abbreviation = abbreviation,
        fullName = "Czech Koruna",
        flagResourceId = R.drawable.cz_flag,
        sign="CZK",
        value = value
    )

    class AUD(
        abbreviation: String,
        value: Double
    ): Currency(
        abbreviation = abbreviation,
        fullName = "Australian Dollar",
        flagResourceId = R.drawable.au_flag,
        sign="AUD",
        value = value
    )

    class CAD(
        abbreviation: String,
        value: Double
    ): Currency(
        abbreviation = abbreviation,
        fullName = "Canadian Dollar",
        flagResourceId = R.drawable.cad_flag,
        sign="CAD",
        value = value
    )
}
