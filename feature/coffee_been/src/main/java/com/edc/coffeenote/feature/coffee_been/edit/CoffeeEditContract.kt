package com.edc.coffeenote.feature.coffee_been.edit

import com.edc.coffeenote.core.model.CoffeeBeenInfo


internal object CoffeeEditContract {
    sealed class SideEffect {
        data object OnSaveSucceed : SideEffect()
        data class ShowToast(val message: String) : SideEffect()
    }

    data class UiState(
        val coffeeBeenInfo: CoffeeBeenInfo = CoffeeBeenInfo(),
        val flavorNote: String = ""
    )
}