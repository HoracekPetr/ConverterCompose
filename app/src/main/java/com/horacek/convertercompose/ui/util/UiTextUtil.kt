package com.horacek.convertercompose.ui.util

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.horacek.convertercompose.ui.util.UiText

@Composable
fun UiText.asString(): String {

    return when (this) {
        is UiText.StringDynamic -> this.text
        is UiText.StringResource -> stringResource(id = this.stringId)
    }

}

fun UiText.asString(context: Context): String{
    return when (this) {
        is UiText.StringDynamic -> this.text
        is UiText.StringResource -> context.getString(this.stringId)
    }
}