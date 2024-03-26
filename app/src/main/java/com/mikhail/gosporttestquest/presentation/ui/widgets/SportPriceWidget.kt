package com.mikhail.gosporttestquest.presentation.ui.widgets

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.mikhail.gosporttestquest.R
import com.mikhail.gosporttestquest.presentation.ui.theme.SportTheme

@Composable
fun SportPriceWidget(
    modifier: Modifier
) {
    Box(
        modifier = modifier
            .border(
                width = 1.dp,
                color = SportTheme.color.pink,
                shape = RoundedCornerShape(6.dp)
            )
    ) {
        Text(
            modifier = Modifier
                .padding(
                    vertical = 8.dp,
                    horizontal = 24.dp
                ),
            text = stringResource(R.string.from) + " 345 " + stringResource(R.string.rub),
            style = SportTheme.typography.price,
            color = SportTheme.color.pink,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}