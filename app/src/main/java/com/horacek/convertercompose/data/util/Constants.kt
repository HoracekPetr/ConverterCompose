package com.horacek.convertercompose.data.util

import com.horacek.convertercompose.BuildConfig

object Constants {

    private const val API_KEY = BuildConfig.API_KEY

    const val BASE_URL = "https://v6.exchangerate-api.com/v6/$API_KEY/"

}