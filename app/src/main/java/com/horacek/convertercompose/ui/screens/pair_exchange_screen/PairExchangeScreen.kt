package com.horacek.convertercompose.ui.screens.pair_exchange_screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Paid
import androidx.compose.material.icons.filled.ToggleOn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.horacek.convertercompose.R
import com.horacek.convertercompose.ui.components.*
import com.horacek.convertercompose.ui.theme.DarkGreen
import com.horacek.convertercompose.util.ExtraLargeDim
import com.horacek.convertercompose.util.MediumDim
import com.horacek.convertercompose.util.SmallDim
import com.horacek.convertercompose.util.navigation.Screens

@Composable
fun PairExchangeScreen(
    viewModel: PairExchangeViewModel = hiltViewModel(),
    navController: NavController
) {

    val amountTextField = viewModel.amountTextFieldState.value
    val gotResult = viewModel.gotResult.value
    val pairExchangeHolder = viewModel.pairExchangeHolder.value
    val fromCurrency = viewModel.fromCurrency.value
    val toCurrency = viewModel.toCurrency.value
    val isLoading = viewModel.isLoading.value
    val isPickDialogOpen = viewModel.isPickCountryDialogOpen.value
    val pickedCurrency = viewModel.pickedCurrency.value ?: PickedCurrency.From

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = MediumDim, end = MediumDim, top = MediumDim, bottom = SmallDim)
    ) {

        if (isPickDialogOpen) {
            CountryPickDialog(
                modifier = Modifier.fillMaxWidth(),
                onDismissRequest = { viewModel.onEvent(PairExchangeEvent.ChangeDialogOpenStatus) },
                pickedCurrency = pickedCurrency,
                setCurrency = { currency, pickedCurrency ->
                    viewModel.onEvent(
                        PairExchangeEvent.ChangeCurrency(
                            pickedCurrency = pickedCurrency,
                            currency = currency
                        )
                    )
                }
            )
        }

        IconButton(
            modifier = Modifier.align(Alignment.End),
            onClick = {
                navController.navigate(Screens.SingleConversion.route) {
                    popUpTo(route = Screens.SingleConversion.route) {
                        inclusive = true
                    }
                }
            }
        )
        {
            Icon(
                modifier = Modifier.size(60.dp),
                imageVector = Icons.Default.ToggleOn,
                tint = DarkGreen,
                contentDescription = "Nav To Pair Description"
            )
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(SmallDim)
        ) {

            Column(
                modifier = Modifier.weight(2f),
                verticalArrangement = Arrangement.SpaceBetween
            ) {

                Text(text = "")

                OutlinedTextField(
                    label = { Text(text = "Amount") },
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color.Black,
                        focusedLabelColor = Color.Black,
                        cursorColor = Color.Black
                    ),
                    value = amountTextField.text ?: "",
                    onValueChange = {
                        viewModel.onEvent(
                            PairExchangeEvent.EnteredAmountText(
                                amount = it
                            )
                        )
                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                )
            }

            Column(
                modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "From")
                PairExchangeThumbnail(
                    thumbnailPhoto = painterResource(
                        id = fromCurrency?.flagResourceId ?: R.drawable.ic_launcher_background
                    ),
                    abbreviation = fromCurrency?.abbreviation ?: "ERR"
                ) {
                    viewModel.onEvent(PairExchangeEvent.ChangePickedCurrency(PickedCurrency.From))
                    viewModel.onEvent(PairExchangeEvent.ChangeDialogOpenStatus)
                }
            }

            Column(
                modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "To")
                PairExchangeThumbnail(
                    thumbnailPhoto = painterResource(
                        id = toCurrency?.flagResourceId ?: R.drawable.ic_launcher_background
                    ),
                    abbreviation = toCurrency?.abbreviation ?: "ERR"
                ) {
                    viewModel.onEvent(PairExchangeEvent.ChangePickedCurrency(PickedCurrency.To))
                    viewModel.onEvent(PairExchangeEvent.ChangeDialogOpenStatus)
                }
            }
        }

        Spacer(modifier = Modifier.size(ExtraLargeDim))

        Button(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            enabled = amountTextField.text != null,
            onClick = {
                viewModel.onEvent(
                    PairExchangeEvent.ConvertButtonClicked(
                        fromCurrencyAbbreviation = fromCurrency?.abbreviation ?: "USD",
                        toCurrencyAbbreviation = toCurrency?.abbreviation ?: "USD",
                        amount = amountTextField.text?.toDoubleOrNull() ?: 0.0
                    )
                )
            },

            shape = RoundedCornerShape(MediumDim),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = DarkGreen,
                contentColor = Color.White
            )
        ) {
            Icon(
                modifier = Modifier.size(32.dp),
                imageVector = Icons.Default.Paid,
                contentDescription = "Convert Button Icon"
            )
            Spacer(modifier = Modifier.width(SmallDim))
            Text(
                text = "Convert!",
                style = TextStyle(fontSize = 20.sp)
            )
        }

        Spacer(modifier = Modifier.size(ExtraLargeDim))
        if (isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.CenterHorizontally))
        } else {
            if (gotResult) {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.SpaceEvenly,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    ResultCard(
                        pickedCurrency = PickedCurrency.From,
                        currency = fromCurrency,
                        amount = amountTextField.text,
                    )
                    Text(text = "=", fontSize = 24.sp)

                    ResultCard(
                        pickedCurrency = PickedCurrency.To,
                        currency = toCurrency,
                        conversionResult = pairExchangeHolder.conversionResult
                    )
                }
            }
        }
    }
}