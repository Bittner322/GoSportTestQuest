package com.mikhail.gosporttestquest.presentation.ui.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.mikhail.gosporttestquest.R

@Composable
fun SportBanner(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.clip(RoundedCornerShape(10.dp))
    ) {
        Image(
            modifier = Modifier
                .widthIn(300.dp),
            painter = painterResource(R.drawable.pizza_banner),
            contentScale = ContentScale.Crop,
            contentDescription = null
        )
    }
}