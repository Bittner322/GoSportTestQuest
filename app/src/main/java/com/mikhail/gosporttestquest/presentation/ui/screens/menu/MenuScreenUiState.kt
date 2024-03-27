package com.mikhail.gosporttestquest.presentation.ui.screens.menu

import com.mikhail.gosporttestquest.data.database.models.CategoryModel

data class MenuScreenUiState(
    val activeTag: CategoryModel
) {
    companion object {
        val default = MenuScreenUiState(
            activeTag = TODO()
        )
    }
}