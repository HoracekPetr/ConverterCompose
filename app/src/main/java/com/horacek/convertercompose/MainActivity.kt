package com.horacek.convertercompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.horacek.convertercompose.ui.theme.ConverterComposeTheme
import com.horacek.convertercompose.util.navigation.Navigation
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ConverterComposeTheme {

                val navController = rememberNavController()

                Navigation(navController = navController)
            }
        }
    }
}
