package com.edc.coffeenote.feature.home

import com.edc.coffeenote.core.model.CoffeeNote
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.persistentListOf

object HomeContract {
    sealed class SideEffect {
        data class NavigateDetailCoffeeNote(val coffeeNote: CoffeeNote) : SideEffect()
        data object NavigateAddCoffeeNote : SideEffect()
        data class ShowToast(val message: String) : SideEffect()
    }

    data class UiState(
        val isLoading: Boolean = true,
        val coffeeNoteList: PersistentList<CoffeeNote> = persistentListOf()
    )
}