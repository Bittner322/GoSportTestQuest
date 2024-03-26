package com.mikhail.gosporttestquest.presentation.ui.widgets.bottom_nav

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import com.mikhail.gosporttestquest.presentation.main_activity.nav_graphs.RootNavGraph
import com.mikhail.gosporttestquest.presentation.ui.theme.SportTheme
import com.mikhail.gosporttestquest.presentation.ui.theme.defaults.SportBottomNavDefaults

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun BottomNavigationBar(navController: NavHostController) {
    var navigationSelectedItem by remember {
        mutableIntStateOf(0)
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            NavigationBar(
                containerColor = SportTheme.color.bottomNavBackground
            ) {
                BottomNavigationItem().bottomNavigationItems().forEachIndexed { index, navigationItem ->
                    NavigationBarItem(
                        selected = index == navigationSelectedItem,
                        label = {
                            Text(
                                text = stringResource(navigationItem.label),
                                style = SportTheme.typography.bottomNavItemStyle
                            )
                        },
                        icon = {
                            Icon(
                                painter = painterResource(navigationItem.icon),
                                contentDescription = null
                            )
                        },
                        onClick = {
                            navigationSelectedItem = index
                            navController.navigate(navigationItem.route)
                        },
                        alwaysShowLabel = true,
                        colors = SportBottomNavDefaults.bottomNavItemColors()
                    )
                }
            }
        }
    ) { _ ->
        RootNavGraph(navController = navController)
    }
}