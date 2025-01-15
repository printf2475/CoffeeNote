package com.edc.coffeenote.feature.coffee_been.list.navigate

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.edc.coffeenote.core.model.CoffeeBeenInfo
import com.edc.coffeenote.feature.coffee_been.list.CoffeeBeenListRoute
import kotlinx.serialization.Serializable


@Serializable
data object CoffeeBeenRoute


fun NavController.navigateToCoffeeBeenList() = navigate(
    route = CoffeeBeenRoute
)

fun NavGraphBuilder.coffeeBeenListScreen(
    onNavigateCoffeeBeenDetailScreen: (CoffeeBeenInfo) -> Unit,
    onNavigateAddCoffeeBeenScreen: () -> Unit
) {
    composable<CoffeeBeenRoute> {
        CoffeeBeenListRoute(
            onNavigateCoffeeBeenDetailScreen = onNavigateCoffeeBeenDetailScreen,
            onNavigateAddCoffeeBeenScreen = onNavigateAddCoffeeBeenScreen
        )
    }
}