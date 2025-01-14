package com.edc.coffeenote.navigation

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.zIndex
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.edc.coffeenote.component.NavigationBar
import com.edc.coffeenote.feature.coffee.edit.navigate.editCoffeeScreen
import com.edc.coffeenote.feature.coffee.edit.navigate.navigateToEditCoffee
import com.edc.coffeenote.feature.home.navigate.HomeRoute
import com.edc.coffeenote.feature.home.navigate.homeScreen
import com.edc.coffeenote.feature.home.navigate.navigateToHome


@Composable
internal fun AppNavHost(
    modifier: Modifier = Modifier,
) {
    val navController = rememberNavController()

    Scaffold(
        modifier = modifier,
        bottomBar = {
            NavigationBar(
                navController = navController,
                destinations = MainDestination.entries.toList(),
                onClick = { destination ->
                    when (destination) {
                        MainDestination.Home -> navController.navigateToHome()
                        MainDestination.Coffee -> navController.navigateToEditCoffee()
                        else -> Unit
                    }
                }
            )
        }
    ) {
        NavHost(
            modifier = Modifier
                .padding(it)
                .zIndex(1f),
            startDestination = HomeRoute,
            navController = navController,
            enterTransition = { EnterTransition.None },
            exitTransition = { ExitTransition.None }
        ) {
            homeScreen(
                onNavigateDetailCoffeeNote = {},
                onNavigateAddCoffeeNote = {}
            )

            editCoffeeScreen(
                onBack = navController::navigateUp
            )
        }
    }
}