package com.alphaomardiallo.a100_days_of_code.common.presentation.mainactivity.components

import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.alphaomardiallo.a100_days_of_code.common.domain.destination.BottomNavDestination

@Composable
fun BottomNavigationBar(
    modifier: Modifier = Modifier,
    isNavigationBarVisible: Boolean,
    items: List<BottomNavDestination>,
    currentRoute: String,
    selectedItemIndex: Int,
    onSelectedItemChange: (Int) -> Unit,
    onItemClick: (String) -> Unit
) {
    if (isNavigationBarVisible) {
        NavigationBar(
            modifier = modifier,
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        ) {
            items.forEachIndexed { index, destination ->
                if (destination.route == currentRoute) {
                    onSelectedItemChange(index)
                }

                NavigationBarItem(
                    alwaysShowLabel = true,
                    icon = {
                        Icon(
                            imageVector = destination.icon,
                            contentDescription = stringResource(id = destination.resId)
                        )
                    },
                    label = { Text(text = stringResource(id = destination.resId)) },
                    selected = selectedItemIndex == index,
                    onClick = {
                        onSelectedItemChange(index)
                        onItemClick(destination.route)
                    }
                )
            }
        }
    }
}
