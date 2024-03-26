package com.mikhail.gosporttestquest.presentation.ui.compose_extensions

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun Modifier.runIf(
    condition: Boolean,
    then: @Composable Modifier.() -> Modifier
): Modifier {
    return if (condition) {
        then()
    } else {
        this
    }
}