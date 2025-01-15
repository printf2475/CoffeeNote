package com.edc.coffeenote.feature.coffee_been.list

import com.edc.coffeenote.core.model.CoffeeBeenInfo
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.persistentListOf


object CoffeeBeenListContract {
    sealed class SideEffect {
        data class ShowToast(val message: String) : SideEffect()
        data class OnNavigateCoffeeBeenDetailScreen(val coffeeBeenInfo: CoffeeBeenInfo) : SideEffect()
        data object OnNavigateAddCoffeeBeenScreen : SideEffect()
    }

    data class UiState(
        val coffeeList: PersistentList<CoffeeBeenInfo> = persistentListOf(),
    )
}