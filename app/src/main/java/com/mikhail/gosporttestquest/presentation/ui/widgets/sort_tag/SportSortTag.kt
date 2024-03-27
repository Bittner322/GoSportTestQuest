package com.mikhail.gosporttestquest.presentation.ui.widgets.sort_tag

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.mikhail.gosporttestquest.data.database.models.CategoryModel
import com.mikhail.gosporttestquest.presentation.ui.compose_extensions.runIf
import com.mikhail.gosporttestquest.presentation.ui.theme.SportTheme

@Composable
fun SportSortTag(
    category: CategoryModel,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    isActive: Boolean = false
) {
    Box(
        modifier = modifier
            .runIf(isActive) {
                background(
                    color = SportTheme.color.lightPink,
                    shape = RoundedCornerShape(6.dp)
                )
            }
            .runIf(!isActive) {
                background(
                    color = SportTheme.color.white,
                    shape = RoundedCornerShape(6.dp)
                )
            }
            .border(
                width = 1.dp,
                color = if (isActive) {
                    SportTheme.color.pink
                } else {
                    SportTheme.color.white
                },
                shape = RoundedCornerShape(6.dp)
            )
            .clip(RoundedCornerShape(6.dp))
            .clickable { onClick() }
    ) {
        Text(
            modifier = Modifier
                .padding(
                    vertical = 8.dp,
                    horizontal = 24.dp
                ),
            text = category.name,
            style = if (isActive) {
                SportTheme.typography.activeTagTitle
            } else {
                SportTheme.typography.inactiveTagTitle
            },
            color = if (isActive) {
                SportTheme.color.pink
            } else {
                SportTheme.color.lightGrey
            },
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}