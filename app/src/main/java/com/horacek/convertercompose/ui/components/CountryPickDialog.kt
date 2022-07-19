package com.horacek.convertercompose.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.window.Dialog
import com.google.accompanist.flowlayout.FlowMainAxisAlignment
import com.google.accompanist.flowlayout.FlowRow
import com.horacek.convertercompose.ui.model.Currency
import com.horacek.convertercompose.util.MediumDim
import com.horacek.convertercompose.util.SmallDim

enum class PickedCurrency{
    From, To
}

@Composable
fun CountryPickDialog(
    modifier: Modifier = Modifier,
    onDismissRequest: () -> Unit = {},
    setCurrency: (Currency, PickedCurrency) -> Unit,
    pickedCurrency: PickedCurrency
) {

    val currencies = Currency.getAllCurrencies()

    Dialog(onDismissRequest = { onDismissRequest() }) {
        Card(
            modifier = modifier,
            shape = RoundedCornerShape(MediumDim),
            elevation = SmallDim
        ) {
            FlowRow(
                modifier = Modifier.padding(MediumDim),
                mainAxisAlignment = FlowMainAxisAlignment.Start,
                mainAxisSpacing = SmallDim,
                crossAxisSpacing = SmallDim
            ) {
                currencies.forEach { currency ->
                    PairExchangeThumbnail(
                        thumbnailPhoto = painterResource(id = currency.flagResourceId ),
                        abbreviation = currency.abbreviation
                    ){
                        setCurrency(currency, pickedCurrency)
                        onDismissRequest()
                    }
                }
            }
        }
    }

}