package com.edc.coffeenote.feature.coffee_been.list

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.edc.coffeenote.core.model.CoffeeBeenInfo
import com.edc.coffeenote.feature.coffee_been.list.screen.CoffeeBeenListScreen
import org.orbitmvi.orbit.compose.collectAsState
import org.orbitmvi.orbit.compose.collectSideEffect

@Composable
fun CoffeeBeenListRoute(
    viewModel: CoffeeBeenListViewModel = hiltViewModel(),
    onNavigateCoffeeBeenDetailScreen: (CoffeeBeenInfo) -> Unit,
    onNavigateAddCoffeeBeenScreen: () -> Unit
) {
    val context = LocalContext.current
    val uiState by viewModel.collectAsState()

    viewModel.collectSideEffect { sideEffect ->
        when (sideEffect) {
            is CoffeeBeenListContract.SideEffect.ShowToast ->
                Toast.makeText(context, sideEffect.message, Toast.LENGTH_SHORT).show()

            is CoffeeBeenListContract.SideEffect.OnNavigateCoffeeBeenDetailScreen ->
                onNavigateCoffeeBeenDetailScreen(sideEffect.coffeeBeenInfo)

            is CoffeeBeenListContract.SideEffect.OnNavigateAddCoffeeBeenScreen ->
                onNavigateAddCoffeeBeenScreen()
        }
    }

    LaunchedEffect(Unit) {
        viewModel.getAllCoffeeBeen()
    }

    CoffeeBeenListScreen(
        coffeeBeenList = uiState.coffeeList,
        onCoffeeBeenClick = viewModel::onNavigateCoffeeBeenDetailScreen,
        onAddCoffeeBeenClick = viewModel::onNavigateAddCoffeeBeenScreen
    )

}