package com.edc.coffeenote.feature.coffee.edit.navigate

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.edc.coffeenote.feature.coffee.edit.CoffeeEditRoute
import kotlinx.serialization.Serializable

@Serializable
data object EditCoffeeRoute


fun NavController.navigateToEditCoffee() = navigate(
    route = EditCoffeeRoute
)

fun NavGraphBuilder.editCoffeeScreen(
    onBack: () -> Unit
) {
    composable<EditCoffeeRoute> {
        CoffeeEditRoute(
            onBack = onBack,
            onSaved = onBack
        )
    }
}