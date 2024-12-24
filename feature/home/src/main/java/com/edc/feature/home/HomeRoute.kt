package com.edc.feature.home

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.edc.coffeenote.core.model.CoffeeNote
import com.edc.feature.home.screen.HomeScreen
import org.orbitmvi.orbit.compose.collectAsState
import org.orbitmvi.orbit.compose.collectSideEffect

@Composable
fun HomeRoute(
    viewModel: HomeViewModel = hiltViewModel(),
    onNavigateEditCoffeeNote: (CoffeeNote) -> Unit,
    onNavigateDetailCoffeeNote: (CoffeeNote) -> Unit
) {
    val context = LocalContext.current

    val uiState by viewModel.collectAsState()

    viewModel.collectSideEffect { effect ->
        when (effect) {
            is HomeContract.SideEffect.NavigateEditCoffeeNote ->
                onNavigateEditCoffeeNote(effect.coffeeNote)

            is HomeContract.SideEffect.NavigateDetailCoffeeNote ->
                onNavigateDetailCoffeeNote(effect.coffeeNote)


            is HomeContract.SideEffect.ShowToast ->
                Toast.makeText(context, effect.message, Toast.LENGTH_SHORT).show()
        }
    }

    HomeScreen(
        coffeeNoteList = uiState.coffeeNoteList,
        onCoffeeNoteClick = viewModel::onCoffeeNoteClick,
    )
}