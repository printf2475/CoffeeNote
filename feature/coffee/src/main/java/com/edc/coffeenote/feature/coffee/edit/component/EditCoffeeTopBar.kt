package com.edc.coffeenote.feature.coffee.edit.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.edc.coffeenote.core.designsystem.component.EdtTopBar
import com.edc.coffeenote.core.designsystem.theme.CoffeeNoteTheme

@Composable
internal fun EditCoffeeTopBar(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit,
    onSaveButtonClick: () -> Unit
) {
    EdtTopBar(
        modifier = modifier,
        title = "Edit Coffee",
        onBackClick = onBackClick,
        actions = {
            IconButton(onClick = onSaveButtonClick) {
                Icon(
                    imageVector = Icons.Default.Check,
                    contentDescription = null
                )
            }
        }
    )
}


@Preview
@Composable
private fun EditCoffeeTopBarPreview() {
    CoffeeNoteTheme {
        EditCoffeeTopBar(
            modifier = Modifier.fillMaxWidth(),
            onBackClick = {},
            onSaveButtonClick = {}
        )
    }
}