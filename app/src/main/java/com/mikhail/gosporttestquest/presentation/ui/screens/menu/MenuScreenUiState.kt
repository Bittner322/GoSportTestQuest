package com.mikhail.gosporttestquest.presentation.ui.screens.menu

import com.mikhail.gosporttestquest.presentation.ui.widgets.sort_tag.Tag

data class MenuScreenUiState(
    val activeTag: Tag
) {
    companion object {
        val default = MenuScreenUiState(
            activeTag = Tag.PIZZA
        )
    }
}