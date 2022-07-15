package com.horacek.convertercompose.util.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.horacek.convertercompose.ui.screens.PairExchangeScreen
import com.horacek.convertercompose.ui.screens.single_exchange_screen.SingleExchangeScreen

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screens.SingleConversion.route){
        composable(route = Screens.SingleConversion.route){
            SingleExchangeScreen(navController = navController)
        }

        composable(route = Screens.PairConversion.route){
            PairExchangeScreen(navController = navController)
        }
    }
}