package com.mikhail.gosporttestquest.presentation.ui.widgets

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.mikhail.gosporttestquest.R
import com.mikhail.gosporttestquest.data.database.models.MealModel
import com.mikhail.gosporttestquest.presentation.ui.theme.SportTheme

@Composable
fun SportMealWidget(
    meal: MealModel,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        HorizontalDivider(
            thickness = 1.dp,
            color = SportTheme.color.dividers
        )
        Row(modifier = Modifier.padding(top = 16.dp)) {
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
            Column(
                modifier = Modifier
                    .padding(
                        start = 22.dp,
                        end = 8.dp
                    )
            ) {
                Text(
                    text = meal.mealName,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    style = SportTheme.typography.productTitle
                )
                Text(
                    modifier = Modifier.padding(top = 8.dp),
                    text = stringResource(R.string.meal_description_stub),
                    maxLines = 5,
                    overflow = TextOverflow.Ellipsis,
                    style = SportTheme.typography.descriptionTitle,
                    color = SportTheme.color.lightGrey
                )
                SportPriceWidget(
                    modifier = Modifier
                        .padding(top = 8.dp)
                        .align(Alignment.End)
                )
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        HorizontalDivider(
            thickness = 1.dp,
            color = SportTheme.color.dividers
        )
    }
}