package com.horacek.convertercompose.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Badge
import androidx.compose.material.BadgedBox
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.horacek.convertercompose.util.MediumDim
import com.horacek.convertercompose.util.SmallDim

@Composable
fun PairExchangeThumbnail(
    modifier: Modifier = Modifier,
    thumbnailPhoto: Painter,
    abbreviation: String,
    onClick: () -> Unit = {}
) {

    Surface(
        modifier = modifier,
        shape = RoundedCornerShape(MediumDim),
        elevation = SmallDim
    ) {
        Column(
            modifier = Modifier
                .clickable { onClick() }
                .padding(MediumDim),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                modifier = Modifier.size(width = 50.dp, height = 30.dp),
                painter = thumbnailPhoto,
                contentDescription = "Thumbnail pic",
                contentScale = ContentScale.FillBounds
            )
            Spacer(modifier = Modifier.size(SmallDim))
            Text(text = abbreviation, style = TextStyle(fontSize = 18.sp))
        }
    }
}