package com.mikhail.gosporttestquest.presentation.ui.widgets.custom_toolbar

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.Saver
import androidx.compose.runtime.saveable.listSaver
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue

@Stable
class SportToolbarScrollState(
    initialHeightOffsetLimit: Float,
    initialHeightOffset: Float,
    initialContentOffset: Float,
) {
    companion object {
        val Saver: Saver<SportToolbarScrollState, *> = listSaver(
            save = { listOf(it.heightOffsetLimit, it.heightOffset, it.contentOffset) },
            restore = {
                SportToolbarScrollState(
                    initialHeightOffsetLimit = it[0],
                    initialHeightOffset = it[1],
                    initialContentOffset = it[2]
                )
            }
        )
    }
    var heightOffsetLimit by mutableStateOf(initialHeightOffsetLimit)
    var heightOffset: Float
        get() = _heightOffset.value
        set(newOffset) {
            _heightOffset.value = newOffset.coerceIn(
                minimumValue = heightOffsetLimit,
                maximumValue = 0f
            )
        }

    var contentOffset by mutableStateOf(initialContentOffset)

    val collapsedFraction: Float
        get() = if (heightOffsetLimit != 0f) {
            heightOffset / heightOffsetLimit
        } else {
            0f
        }

    private var _heightOffset = mutableStateOf(initialHeightOffset)
}

@Composable
internal fun rememberToolbarScrollState(
    initialHeightOffsetLimit: Float = -Float.MAX_VALUE,
    initialHeightOffset: Float = 0f,
    initialContentOffset: Float = 0f
) = rememberSaveable(saver = SportToolbarScrollState.Saver) {
    SportToolbarScrollState(
        initialHeightOffsetLimit,
        initialHeightOffset,
        initialContentOffset
    )
}