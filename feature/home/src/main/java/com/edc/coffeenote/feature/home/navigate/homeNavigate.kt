package com.edc.coffeenote.feature.home.navigate

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.edc.coffeenote.core.model.CoffeeNote
import com.edc.coffeenote.feature.home.HomeRoute
import kotlinx.serialization.Serializable

@Serializable
object HomeRoute

fun NavController.navigateToHome() = navigate(
    route = HomeRoute
)

fun NavGraphBuilder.homeScreen(
    onNavigateDetailCoffeeNote: (CoffeeNote) -> Unit,
    onNavigateAddCoffeeNote: () -> Unit
) {
    composable<HomeRoute> {
        HomeRoute(
            onNavigateDetailCoffeeNote = onNavigateDetailCoffeeNote,
            onNavigateAddCoffeeNote = onNavigateAddCoffeeNote
        )
    }
}