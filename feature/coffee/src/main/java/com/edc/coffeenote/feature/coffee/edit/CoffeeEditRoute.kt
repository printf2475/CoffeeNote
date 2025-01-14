package com.edc.coffeenote.feature.coffee.edit

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.edc.coffeenote.feature.coffee.edit.screen.CoffeeEditScreen
import org.orbitmvi.orbit.compose.collectAsState
import org.orbitmvi.orbit.compose.collectSideEffect

@Composable
fun CoffeeEditRoute(
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
        beenName = uiState.coffeeNote.beenInfo.beenName,
        roastery = uiState.coffeeNote.beenInfo.roastery ?: "",
        flavorNotes = uiState.coffeeNote.beenInfo.flavorNotes,
        flavorNote = uiState.flavorNote,
        roastingPoint = uiState.coffeeNote.beenInfo.roastingPoint,
        notes = uiState.coffeeNote.notes,
        onBeenNameChange = viewModel::onBeenNameChange,
        onRoasteryChange = viewModel::onRoasteryChange,
        onFlavorNoteChange = viewModel::onFlavorNoteChange,
        onFlavorNoteAdd = viewModel::onAddFlavorNote,
        onFlavorNoteDelete = viewModel::onDeleteFlavorNote,
        onRoastingPointChange = viewModel::onRoastingPointChange,
        onNotesChange = viewModel::onNotesChange,
        onBackClick = onBack,
        onSaved = viewModel::onSaveCoffee,
    )
}