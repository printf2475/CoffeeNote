package com.edc.coffeenote.feature.coffee_been.list

import android.util.Log
import androidx.lifecycle.ViewModel
import com.edc.coffeenote.core.domain.usecase.GetAllCoffeeBeenUseCase
import com.edc.coffeenote.core.model.CoffeeBeenInfo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.collections.immutable.toPersistentList
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.onStart
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject
import com.edc.coffeenote.feature.coffee_been.list.CoffeeBeenListContract as Contract

@HiltViewModel
class CoffeeBeenListViewModel @Inject constructor(
    private val getAllCoffeeBeenUseCase: GetAllCoffeeBeenUseCase
) : ViewModel(), ContainerHost<Contract.UiState, Contract.SideEffect> {

    override val container = container<Contract.UiState, Contract.SideEffect>(Contract.UiState())

    fun getAllCoffeeBeen() = intent {
        getAllCoffeeBeenUseCase()
            .catch {
                postSideEffect(Contract.SideEffect.ShowToast("Get All Coffee Been Failed"))
            }
            .onStart { Log.d(TAG, "getAllCoffeeBeen") }
            .collectLatest { coffeeBeenList ->
                reduce {
                    state.copy(coffeeList = coffeeBeenList.toPersistentList())
                }
            }
    }

    fun onNavigateCoffeeBeenDetailScreen(coffeeBeenInfo: CoffeeBeenInfo) = intent {
        postSideEffect(Contract.SideEffect.OnNavigateCoffeeBeenDetailScreen(coffeeBeenInfo))
    }

    fun onNavigateAddCoffeeBeenScreen() = intent {
        postSideEffect(Contract.SideEffect.OnNavigateAddCoffeeBeenScreen)
    }

    companion object{
        private const val TAG = "CoffeeBeenListViewModel"
    }
}