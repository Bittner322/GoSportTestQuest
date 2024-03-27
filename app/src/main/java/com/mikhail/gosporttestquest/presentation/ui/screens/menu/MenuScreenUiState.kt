package com.mikhail.gosporttestquest.presentation.ui.screens.menu

private const val DEFAULT_ACTIVE_CATEGORY_TAG = "Seafood"

data class MenuScreenUiState(
    val activeTag: String
) {
    companion object {
        val default = MenuScreenUiState(
            activeTag = DEFAULT_ACTIVE_CATEGORY_TAG
        )
    }
}