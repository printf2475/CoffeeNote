package com.edc.coffeenote.feature.coffee.edit

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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
class CoffeeEditViewModel @Inject constructor(
    private val upsertCoffeeNoteUseCase: UpsertCoffeeNoteUseCase
) : ViewModel(), ContainerHost<CoffeeEditContract.UiState, CoffeeEditContract.SideEffect> {

    override val container = container<CoffeeEditContract.UiState, CoffeeEditContract.SideEffect>(
        initialState = CoffeeEditContract.UiState()
    )

    fun onBeenNameChange(beenName: String) = intent {
        reduce {
            state.copy(
                coffeeNote = state.coffeeNote.copy(
                    beenInfo = state.coffeeNote.beenInfo.copy(beenName = beenName),
                )
            )
        }
    }

    fun onRoasteryChange(roastery: String) = intent {
        reduce {
            state.copy(
                coffeeNote = state.coffeeNote.copy(
                    beenInfo = state.coffeeNote.beenInfo.copy(roastery = roastery)
                )
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
                coffeeNote = state.coffeeNote.copy(
                    beenInfo = state.coffeeNote.beenInfo.copy(
                        flavorNotes = state.coffeeNote.beenInfo.flavorNotes.toMutableList().apply {
                            add(state.flavorNote)
                        }.toPersistentList()
                    )
                )
            )
        }
    }

    fun onDeleteFlavorNote(flavorNote: String) = intent {
        reduce {
            state.copy(
                coffeeNote = state.coffeeNote.copy(
                    beenInfo = state.coffeeNote.beenInfo.copy(
                        flavorNotes = state.coffeeNote.beenInfo.flavorNotes.toMutableList().apply {
                            if (contains(flavorNote)) {
                                remove(flavorNote)
                            }
                        }.toPersistentList()
                    )
                )
            )
        }
    }

    fun onRoastingPointChange(roastingPoint: Int) = intent {
        reduce {
            state.copy(
                coffeeNote = state.coffeeNote.copy(
                    beenInfo = state.coffeeNote.beenInfo.copy(
                        roastingPoint = roastingPoint
                    )
                )
            )
        }
    }

    fun onNotesChange(notes: String) = intent {
        reduce {
            state.copy(
                coffeeNote = state.coffeeNote.copy(notes = notes)
            )
        }
    }


    fun onSaveCoffee() = intent {
        upsertCoffeeNoteUseCase(state.coffeeNote.copy(date = Date()))
            .catch { postSideEffect(CoffeeEditContract.SideEffect.ShowToast("CoffeeNote Save Error")) }
            .onCompletion { postSideEffect(CoffeeEditContract.SideEffect.OnSaveSucceed) }
            .launchIn(viewModelScope)
    }
}