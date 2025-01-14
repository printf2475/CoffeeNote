package com.edc.coffeenote.feature.coffee.edit

import com.edc.coffeenote.core.model.CoffeeNote


object CoffeeEditContract {
    sealed class SideEffect {
        data object OnSaveSucceed : SideEffect()
        data class ShowToast(val message: String) : SideEffect()
    }

    data class UiState(
        val coffeeNote: CoffeeNote = CoffeeNote(),
        val flavorNote: String = ""
    )
}