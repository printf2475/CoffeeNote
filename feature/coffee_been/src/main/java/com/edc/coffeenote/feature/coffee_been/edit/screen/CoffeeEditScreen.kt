package com.edc.coffeenote.feature.coffee_been.edit.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.edc.coffeenote.core.designsystem.theme.Gray400
import com.edc.coffeenote.core.designsystem.theme.LocalTypography
import com.edc.coffeenote.feature.coffee_been.edit.component.EditCoffeeTopBar
import com.edc.coffeenote.feature.coffee_been.edit.component.FlavorNoteChip
import kotlinx.collections.immutable.PersistentList

@Composable
internal fun CoffeeEditScreen(
    beenName: String,
    roastery: String,
    flavorNotes: PersistentList<String>,
    flavorNote: String,
    roastingPoint: Int,
    onBeenNameChange: (String) -> Unit,
    onRoasteryChange: (String) -> Unit,
    onFlavorNoteAdd: () -> Unit,
    onFlavorNoteChange: (String) -> Unit,
    onFlavorNoteDelete: (String) -> Unit,
    onRoastingPointChange: (Int) -> Unit,
    onBackClick: () -> Unit,
    onSaved: () -> Unit,
) {
    val typography = LocalTypography.current
    Scaffold(
        modifier = Modifier.fillMaxWidth(),
        topBar = {
            EditCoffeeTopBar(
                modifier = Modifier.fillMaxWidth(),
                onBackClick = onBackClick,
                onSaveButtonClick = onSaved
            )
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(it)
                .padding(20.dp)
                .verticalScroll(rememberScrollState()),
        ) {
            Text(
                text = "Coffee Name",
                style = typography.m12
            )

            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = beenName,
                textStyle = typography.b20,
                onValueChange = onBeenNameChange
            )

            Spacer(modifier = Modifier.height(10.dp))


            Text(
                text = "Roastery Name",
                style = typography.m12
            )
            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = roastery,
                textStyle = typography.m14,
                onValueChange = onRoasteryChange
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "Roasting Point",
                style = typography.m12
            )

            Slider(
                value = roastingPoint.toFloat(),
                valueRange = 1f..5f,
                steps = 5,
                onValueChange = { onRoastingPointChange(it.toInt()) }
            )

            Spacer(modifier = Modifier.height(10.dp))


            Text(
                text = "Flavor Notes",
                style = typography.m12
            )
            Row(
                modifier = Modifier.height(40.dp),
                horizontalArrangement = Arrangement.spacedBy(4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (flavorNotes.isEmpty()){
                    Text(
                        text = "Ex) Chocolate, Vanilla",
                        style = typography.b14,
                        color = Gray400
                    )
                } else {
                    flavorNotes.forEach { note ->
                        FlavorNoteChip(
                            note = note,
                            onClick = onFlavorNoteDelete
                        )
                    }
                }
            }

            Row {
                TextField(
                    modifier = Modifier.weight(1f),
                    value = flavorNote,
                    onValueChange = onFlavorNoteChange
                )

                TextButton(onClick = onFlavorNoteAdd) {
                    Text(text = "Add")
                }
            }

            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}