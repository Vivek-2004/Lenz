package com.fitting.lenz.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.TopAppBar
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.fitting.lenz.models.ColorSchemeModel
import com.fitting.lenz.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar(
    colorScheme: ColorSchemeModel,
    navController: NavController,
    currentScreenName: String
) {
    val title = when (currentScreenName) {
        "Edit" -> "Edit Charges"
        "ShiftingEdit" -> "Edit"
        "FittingEdit" -> "Edit"
        "SingleOrderItemHolder/{groupOrderId}" -> "Group Details"
        "OrderDetails/{orderId}" -> "Order Details"
        "ShopOrdersHolder/{shopId}" -> "Pending Orders"
        "History/{shopId}" -> "Order History"
        "ShopDetails/{shopId}" -> "Shop Details"
        else -> currentScreenName
    }
    var showNavigationIcon by remember { mutableStateOf(false) }
    showNavigationIcon = (
                    title != NavigationDestination.Orders.name &&
                    title != NavigationDestination.Shops.name &&
                    title != "Edit Charges" &&
                    title != NavigationDestination.Admin.name
            )
    TopAppBar(
        modifier = Modifier.background(colorScheme.bgColor),
        title = {
            Column {
                Column(
                    modifier = Modifier.fillMaxWidth()
                        .padding(
                            end = if (showNavigationIcon) 50.dp else 20.dp
                        ),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = title,
                        color = colorScheme.compColor,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 33.sp
                    )
                }
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.White,
            titleContentColor = Color.Black
        ),
        navigationIcon = {
            if (showNavigationIcon) {
                IconButton(
                    modifier = Modifier.padding(start = 8.dp),
                    onClick = { navController.popBackStack() }
                ) {
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowLeft,
                        contentDescription = "Back Button",
                        tint = colorScheme.compColor,
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }
        }
    )
}


@Composable
fun BottomNavigationBar(
    colorScheme: ColorSchemeModel,
    navController: NavController,
    onTitleChange: (String) -> Unit
) {
    val currentDestination = navController.currentBackStackEntryAsState().value?.destination
    val items = listOf(
        NavigationDestination.Orders.name,
        NavigationDestination.Shops.name,
        NavigationDestination.Edit.name,
        NavigationDestination.Admin.name
    )

    Column(modifier = Modifier.wrapContentSize()) {
        HorizontalDivider(
            color = colorScheme.compColor.copy(alpha = 0.55f),
            thickness = 2.dp
        )
        NavigationBar(
            modifier = Modifier
                .navigationBarsPadding()
                .height(80.dp),
            containerColor = Color.White
        ) {
            items.forEach { screen ->
                val icon = when (screen) {
                    NavigationDestination.Orders.name -> painterResource(R.drawable.orders)
                    NavigationDestination.Shops.name -> painterResource(R.drawable.shops)
                    NavigationDestination.Edit.name -> painterResource(R.drawable.edit)
                    NavigationDestination.Admin.name -> painterResource(R.drawable.profile)
                    else -> painterResource(R.drawable.orders)
                }
                NavigationBarItem(
                    selected = currentDestination?.route == screen,
                    interactionSource = remember { MutableInteractionSource() },
                    icon = {
                        Icon(
                            modifier = Modifier.size(30.dp),
                            painter = icon,
                            contentDescription = screen,
                            tint = Color.Unspecified
                        )
                    },
                    label = {
                        Text(
                            text = screen,
                            fontSize = 14.sp,
                            color = colorScheme.compColor,
                            fontWeight = FontWeight.Bold
                        )
                    },
                    onClick = {
                        onTitleChange(screen)
                        navController.navigate(screen) {
                            popUpTo(navController.graph.startDestinationId) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = MaterialTheme.colorScheme.primary,
                        unselectedIconColor = MaterialTheme.colorScheme.onSurfaceVariant,
                        selectedTextColor = MaterialTheme.colorScheme.primary,
                        unselectedTextColor = MaterialTheme.colorScheme.onSurfaceVariant,
                        indicatorColor = Color.LightGray,
                    )
                )
            }
        }
    }
}