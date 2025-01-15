package com.edc.coffeenote.feature.coffee_been.edit

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.edc.coffeenote.core.domain.usecase.UpsertCoffeeBeenUseCase
import com.edc.coffeenote.core.domain.usecase.UpsertCoffeeNoteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.collections.immutable.toPersistentList
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onCompletion
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.viewmodel.container
import java.util.Date
import javax.inject.Inject

@HiltViewModel
internal class CoffeeEditViewModel @Inject constructor(
    private val upsertCoffeeBeenUseCase: UpsertCoffeeBeenUseCase
) : ViewModel(), ContainerHost<CoffeeEditContract.UiState, CoffeeEditContract.SideEffect> {

    override val container = container<CoffeeEditContract.UiState, CoffeeEditContract.SideEffect>(
        initialState = CoffeeEditContract.UiState()
    )

    fun onBeenNameChange(beenName: String) = intent {
        reduce {
            state.copy(
                coffeeBeenInfo = state.coffeeBeenInfo.copy(beenName = beenName)
            )
        }
    }

    fun onRoasteryChange(roastery: String) = intent {
        reduce {
            state.copy(
                coffeeBeenInfo = state.coffeeBeenInfo.copy(roastery = roastery)
            )
        }
    }

    fun onFlavorNoteChange(flavorNote: String) = intent {
        reduce {
            state.copy(flavorNote = flavorNote)
        }
    }

    fun onAddFlavorNote() = intent {
        if (state.flavorNote.isEmpty()) return@intent
        reduce {
            state.copy(
                flavorNote = "",
                coffeeBeenInfo = state.coffeeBeenInfo.copy(
                    flavorNotes = state.coffeeBeenInfo.flavorNotes.toMutableList().apply {
                        add(state.flavorNote)
                    }.toPersistentList()
                )
            )
        }
    }

    fun onDeleteFlavorNote(flavorNote: String) = intent {
        reduce {
            state.copy(
                coffeeBeenInfo = state.coffeeBeenInfo.copy(
                    flavorNotes = state.coffeeBeenInfo.flavorNotes.toMutableList().apply {
                        if (contains(flavorNote)) {
                            remove(flavorNote)
                        }
                    }.toPersistentList()
                )
            )
        }
    }

    fun onRoastingPointChange(roastingPoint: Int) = intent {
        reduce {
            state.copy(
                coffeeBeenInfo = state.coffeeBeenInfo.copy(
                    roastingPoint = roastingPoint
                )
            )
        }
    }



    fun onSaveCoffee() = intent {
        upsertCoffeeBeenUseCase(state.coffeeBeenInfo.copy(roastingDate = Date()))
            .catch { postSideEffect(CoffeeEditContract.SideEffect.ShowToast("CoffeeNote Save Error")) }
            .onCompletion { postSideEffect(CoffeeEditContract.SideEffect.OnSaveSucceed) }
            .launchIn(viewModelScope)
    }
}