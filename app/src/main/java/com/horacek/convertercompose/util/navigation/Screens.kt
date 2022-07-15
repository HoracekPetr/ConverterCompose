package com.horacek.convertercompose.util.navigation

sealed class Screens(val route: String){
    object SingleConversion: Screens(route = "single_conversion")
    object PairConversion: Screens(route = "pair_conversion")
}