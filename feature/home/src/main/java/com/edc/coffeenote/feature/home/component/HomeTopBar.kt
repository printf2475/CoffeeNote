package com.edc.coffeenote.feature.home.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.edc.coffeenote.core.designsystem.component.EdtTopBar
import com.edc.coffeenote.core.designsystem.theme.CoffeeNoteTheme

@Composable
internal fun HomeTopBar(
    modifier: Modifier = Modifier,
    onAddButtonClick: () -> Unit
) {
    EdtTopBar(
        modifier = modifier,
        title = "CoffeeNote",
        actions = {
            IconButton(onClick = onAddButtonClick) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = null
                )
            }
        }
    )
}


@Preview
@Composable
private fun HomeTopBarPreview() {
    CoffeeNoteTheme {
        HomeTopBar(
            modifier = Modifier.fillMaxWidth(),
            onAddButtonClick = {}
        )
    }
}