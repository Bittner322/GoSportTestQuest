package com.mikhail.gosporttestquest.presentation.ui.widgets

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.mikhail.gosporttestquest.data.database.models.MealModel

@Composable
fun SportMealWidget(
    meal: MealModel,
    modifier: Modifier = Modifier
) {
    Row(modifier = modifier) {
        AsyncImage(
            modifier = Modifier
                .padding(
                    start = 16.dp,
                    top = 16.dp,
                    bottom = 16.dp
                )
                .sizeIn(135.dp),
            model = meal.mealPicture,
            contentDescription = null
        )
        Column {

        }
    }
}