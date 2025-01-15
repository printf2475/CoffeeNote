package com.edc.coffeenote.feature.home

import android.util.Log
import androidx.lifecycle.ViewModel
import com.edc.coffeenote.core.domain.usecase.GetAllCoffeeNoteUseCase
import com.edc.coffeenote.core.model.CoffeeNote
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.collections.immutable.toPersistentList
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collectLatest
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getAllCoffeeNoteUseCase: GetAllCoffeeNoteUseCase,
) : ViewModel(), ContainerHost<HomeContract.UiState, HomeContract.SideEffect> {

    override val container = container<HomeContract.UiState, HomeContract.SideEffect>(
        initialState = HomeContract.UiState()
    )

    fun getAllCoffeeNote() = intent {
        getAllCoffeeNoteUseCase()
            .catch {
                Log.e(TAG, "getAllCoffeeNote: ", it)
                postSideEffect(HomeContract.SideEffect.ShowToast("CoffeeNotes Load Error"))
            }
            .collectLatest { coffeeNoteList ->
                reduce {
                    state.copy(
                        isLoading = false,
                        coffeeNoteList = coffeeNoteList.toPersistentList()
                    )
                }
            }
    }

    fun onCoffeeNoteClick(coffeeNote: CoffeeNote) = intent {
        postSideEffect(HomeContract.SideEffect.NavigateDetailCoffeeNote(coffeeNote))
    }

    fun onAddCoffeeNoteClick() = intent {
        postSideEffect(HomeContract.SideEffect.NavigateAddCoffeeNote)
    }

    companion object {
        private const val TAG: String = "HomeViewModel"
    }
}