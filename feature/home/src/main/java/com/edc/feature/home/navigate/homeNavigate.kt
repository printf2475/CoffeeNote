package com.edc.feature.home.navigate

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.edc.coffeenote.core.model.CoffeeNote
import com.edc.feature.home.HomeRoute
import kotlinx.serialization.Serializable

@Serializable
object HomeRoute

fun NavController.navigateToCalendar() = navigate(
    route = HomeRoute
)

fun NavGraphBuilder.homeScreen(
    onNavigateDetailCoffeeNote: (CoffeeNote) -> Unit,
    onNavigateEditCoffeeNote: (CoffeeNote) -> Unit
) {
    composable<HomeRoute> {
        HomeRoute(
            onNavigateDetailCoffeeNote = onNavigateDetailCoffeeNote,
            onNavigateEditCoffeeNote = onNavigateEditCoffeeNote
        )
    }
}