package com.edc.coffeenote.navigation

import androidx.annotation.DrawableRes
import com.edc.coffeenote.R
import com.edc.coffeenote.feature.coffee_been.edit.navigate.EditCoffeeRoute
import com.edc.coffeenote.feature.home.navigate.HomeRoute
import kotlin.reflect.KClass

enum class MainDestination(
    @DrawableRes val selectedIcon: Int,
    @DrawableRes val unselectedIcon: Int,
    val route: KClass<*>,
) {
    Home(
        selectedIcon = R.drawable.ic_launcher_foreground,
        unselectedIcon = R.drawable.ic_launcher_foreground,
        route = HomeRoute::class
    ),
    Coffee(
        selectedIcon = R.drawable.ic_launcher_foreground,
        unselectedIcon = R.drawable.ic_launcher_foreground,
        route = EditCoffeeRoute::class
    )
}