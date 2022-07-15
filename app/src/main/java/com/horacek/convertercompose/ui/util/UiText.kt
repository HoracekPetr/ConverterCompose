package com.horacek.convertercompose.ui.util

import androidx.annotation.StringRes
import com.horacek.convertercompose.R

sealed class UiText {
    data class StringDynamic(val text: String) : UiText()
    data class StringResource(@StringRes val stringId: Int) : UiText()

    companion object {
        fun unknownError(): UiText {
            return StringResource(R.string.an_unknown_error_occured)
        }
    }
}
