package com.horacek.convertercompose.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.horacek.convertercompose.util.MediumDim
import com.horacek.convertercompose.util.SmallDim

enum class CurrencyComposableType {
    Main, Thumbnail
}

@Composable
fun CurrencyComposable(
    modifier: Modifier = Modifier,
    currencyComposableType: CurrencyComposableType = CurrencyComposableType.Main,
    currencyCountryFlag: Painter,
    currencyAbbreviation: String,
    currencyFullName: String,
    currencySign: String,
    currencyValue: Double,
    onClick: () -> Unit = {}
) {
    Surface(
        modifier = modifier,
        shape = RoundedCornerShape(MediumDim),
        elevation = SmallDim
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { onClick() }
                .padding(MediumDim)
        ) {
            when(currencyComposableType){
                CurrencyComposableType.Main -> {
                    Row(
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            modifier = Modifier.size(width = 100.dp, height = 60.dp),
                            painter = currencyCountryFlag,
                            contentDescription = "Country flag",
                            contentScale = ContentScale.FillBounds
                        )

                        Spacer(modifier = Modifier.size(MediumDim))

                        Text(text = currencyAbbreviation, style = TextStyle(fontSize = 42.sp))

                        Spacer(modifier = Modifier.weight(1f))

                        Text(
                            text = currencyFullName,
                            style = TextStyle(fontSize = 16.sp, color = Color.Gray)
                        )
                    }

                    Spacer(modifier = Modifier.size(MediumDim))

                    Text(
                        modifier = Modifier.align(Alignment.End),
                        text = "$currencySign $currencyValue",
                        style = TextStyle(fontSize = 48.sp, fontWeight = FontWeight.Bold)
                    )
                }
                CurrencyComposableType.Thumbnail -> {
                    Row(
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            modifier = Modifier.size(width = 70.dp, height = 40.dp),
                            painter = currencyCountryFlag,
                            contentDescription = "Country flag",
                            contentScale = ContentScale.FillBounds
                        )

                        Spacer(modifier = Modifier.size(MediumDim))

                        Text(text = currencyAbbreviation, style = TextStyle(fontSize = 32.sp))

                        Spacer(modifier = Modifier.weight(1f))

                        Text(
                            text = "$currencySign $currencyValue",
                            style = TextStyle(fontSize = 24.sp)
                        )
                    }
                }
            }
        }
    }
}
