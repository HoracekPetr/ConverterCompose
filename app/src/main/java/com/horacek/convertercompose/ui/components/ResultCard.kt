package com.horacek.convertercompose.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.horacek.convertercompose.ui.model.Currency
import com.horacek.convertercompose.util.MediumDim

@Composable
fun ResultCard(
    modifier: Modifier = Modifier,
    pickedCurrency: PickedCurrency,
    currency: Currency?,
    amount: String? = null,
    conversionResult: Double? = null,
    fontSize: TextUnit = 24.sp
) {

    Card(
        modifier = modifier,
        shape = RoundedCornerShape(MediumDim)
    ) {
        Row(
            modifier = Modifier.padding(MediumDim),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                modifier = Modifier.size(width = 50.dp, height = 30.dp),
                painter = painterResource(id = currency?.flagResourceId ?: 0),
                contentDescription = "Currency icon"
            )
            Spacer(modifier = Modifier.size(MediumDim))
            Text(
                text = when (pickedCurrency) {
                    PickedCurrency.From -> {
                        "$amount ${currency?.abbreviation}"
                    }
                    PickedCurrency.To -> {
                        "$conversionResult ${currency?.sign}"
                    }
                },
                style = TextStyle(fontSize = fontSize)
            )
        }
    }

}