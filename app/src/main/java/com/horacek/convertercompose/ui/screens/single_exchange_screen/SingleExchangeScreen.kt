package com.horacek.convertercompose.ui.screens.single_exchange_screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ToggleOff
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.horacek.convertercompose.R
import com.horacek.convertercompose.domain.single_exchange_usecase.model.Currency
import com.horacek.convertercompose.domain.single_exchange_usecase.model.CurrencyHolder
import com.horacek.convertercompose.ui.components.CurrencyComposable
import com.horacek.convertercompose.ui.components.CurrencyComposableType
import com.horacek.convertercompose.util.LargeDim
import com.horacek.convertercompose.util.MediumDim
import com.horacek.convertercompose.util.SmallDim
import com.horacek.convertercompose.util.navigation.Screens


@Composable
fun SingleExchangeScreen(
    navController: NavController,
    viewModel: SingleExchangeViewModel = hiltViewModel()
) {

    val isLoading = viewModel.isLoading.value
    val currencyHolder = viewModel.currencyHolder.value

    val mainCurrency = currencyHolder.mainCurrency
    val currencyList = currencyHolder.conversionsList?.filterNotNull()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = MediumDim, end = MediumDim, top = MediumDim, bottom = SmallDim)
    ) {
        when (isLoading) {
            true -> {
                Box(modifier = Modifier.fillMaxSize()) {
                    CircularProgressIndicator(
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
            }
            false -> {
                IconButton(
                    modifier = Modifier.align(Alignment.End),
                    onClick = { navController.navigate(Screens.PairConversion.route) })
                {
                    Icon(
                        modifier = Modifier.size(60.dp),
                        imageVector = Icons.Default.ToggleOff,
                        contentDescription = "Nav To Pair Description"
                    )
                }

                Column(modifier = Modifier.fillMaxSize()) {
                    mainCurrency?.let { currency ->
                        CurrencyComposable(
                            modifier = Modifier.fillMaxWidth(),
                            currencyCountryFlag = painterResource(
                                id = currency.flagResourceId
                            ),
                            currencyAbbreviation = currency.abbreviation ?: "ERROR",
                            currencyFullName = currency.fullName ?: "ERROR NAME",
                            currencySign = currency.sign ?: "ERROR SIGN",
                            currencyValue = currency.value ?: 0.0
                        )
                    }

                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize(),
                        verticalArrangement = Arrangement.spacedBy(MediumDim),
                        contentPadding = PaddingValues(vertical = MediumDim, horizontal = LargeDim)
                    ) {
                        currencyList?.let { currencies ->
                            items(items = currencies) { currency ->
                                CurrencyComposable(
                                    currencyComposableType = CurrencyComposableType.Thumbnail,
                                    currencyCountryFlag = painterResource(id = currency.flagResourceId),
                                    currencyAbbreviation = currency.abbreviation,
                                    currencyFullName = currency.fullName,
                                    currencySign = currency.sign,
                                    currencyValue = currency.value
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}