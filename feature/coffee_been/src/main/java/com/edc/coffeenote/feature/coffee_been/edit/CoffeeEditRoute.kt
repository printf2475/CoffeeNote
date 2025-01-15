package com.edc.coffeenote.feature.coffee_been.edit

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.edc.coffeenote.feature.coffee_been.edit.screen.CoffeeEditScreen
import org.orbitmvi.orbit.compose.collectAsState
import org.orbitmvi.orbit.compose.collectSideEffect

@Composable
internal fun CoffeeEditRoute(
    viewModel: CoffeeEditViewModel = hiltViewModel(),
    onBack: () -> Unit,
    onSaved: () -> Unit,
) {
    val context = LocalContext.current
    val uiState by viewModel.collectAsState()

    viewModel.collectSideEffect { sideEffect ->
        when (sideEffect) {
            CoffeeEditContract.SideEffect.OnSaveSucceed -> onSaved()
            is CoffeeEditContract.SideEffect.ShowToast ->
                Toast.makeText(context, sideEffect.message, Toast.LENGTH_SHORT).show()
        }
    }

    CoffeeEditScreen(
        beenName = uiState.coffeeBeenInfo.beenName,
        roastery = uiState.coffeeBeenInfo.roastery ?: "",
        flavorNotes = uiState.coffeeBeenInfo.flavorNotes,
        flavorNote = uiState.flavorNote,
        roastingPoint = uiState.coffeeBeenInfo.roastingPoint,
        onBeenNameChange = viewModel::onBeenNameChange,
        onRoasteryChange = viewModel::onRoasteryChange,
        onFlavorNoteChange = viewModel::onFlavorNoteChange,
        onFlavorNoteAdd = viewModel::onAddFlavorNote,
        onFlavorNoteDelete = viewModel::onDeleteFlavorNote,
        onRoastingPointChange = viewModel::onRoastingPointChange,
        onBackClick = onBack,
        onSaved = viewModel::onSaveCoffee,
    )
}