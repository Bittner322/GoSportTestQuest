package com.mikhail.gosporttestquest.presentation.ui.widgets.sort_tag

import com.mikhail.gosporttestquest.R

enum class Tag(
    val tagStringResource: Int
) {
    PIZZA(tagStringResource = R.string.tag_pizza),
    COMBO(tagStringResource = R.string.tag_combo),
    DRINKS(tagStringResource = R.string.tag_drinks),
    DESSERTS(tagStringResource = R.string.tag_desserts)
}