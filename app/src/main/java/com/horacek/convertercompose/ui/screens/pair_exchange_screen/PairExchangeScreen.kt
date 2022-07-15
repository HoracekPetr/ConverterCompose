package com.horacek.convertercompose.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ToggleOff
import androidx.compose.material.icons.filled.ToggleOn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.horacek.convertercompose.util.MediumDim
import com.horacek.convertercompose.util.navigation.Screens

@Composable
fun PairExchangeScreen(
    navController: NavController
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(MediumDim), contentAlignment = Alignment.Center
    ) {
        IconButton(
            modifier = Modifier.align(Alignment.TopEnd),
            onClick = {
                navController.navigate(Screens.SingleConversion.route){
                    popUpTo(route = Screens.SingleConversion.route){
                        inclusive = true
                    }
                }
            })
        {
            Icon(
                modifier = Modifier.size(60.dp),
                imageVector = Icons.Default.ToggleOn,
                tint = Color.Green,
                contentDescription = "Nav To Pair Description"
            )
        }
        Text(text = "Pair Conversion Screen")
    }
}