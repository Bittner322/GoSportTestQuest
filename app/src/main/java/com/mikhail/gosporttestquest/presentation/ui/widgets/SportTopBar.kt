package com.mikhail.gosporttestquest.presentation.ui.widgets

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.mikhail.gosporttestquest.R
import com.mikhail.gosporttestquest.presentation.ui.theme.SportTheme
import com.mikhail.gosporttestquest.presentation.ui.theme.defaults.SportTopBarDefaults

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SportTopBar(
    city: String,
    modifier: Modifier = Modifier
) {
    CenterAlignedTopAppBar(
        modifier = modifier,
        navigationIcon = {
            Row(
                modifier = Modifier.padding(start = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = city,
                    color = SportTheme.color.black,
                    style = SportTheme.typography.cityTitle,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.width(8.dp))
                Icon(
                    painter = painterResource(R.drawable.ic_arrow_down),
                    contentDescription = null
                )
            }
        },
        actions = {
            Icon(
                modifier = Modifier.padding(end = 16.dp),
                painter = painterResource(R.drawable.ic_qr_code),
                contentDescription = null
            )
        },
        title = {},
        colors = SportTopBarDefaults.topBarColors()
    )
}