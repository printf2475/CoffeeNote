package com.edc.feature.home.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.edc.coffeenote.core.designsystem.component.EdtTopBar
import com.edc.coffeenote.core.designsystem.theme.CoffeeNoteTheme

@Composable
internal fun HomeTopBar(modifier: Modifier = Modifier) {
    EdtTopBar(
        modifier = modifier,
        title = "CoffeeNote",
    )
}


@Preview
@Composable
private fun HomeTopBarPreview() {
    CoffeeNoteTheme {
        HomeTopBar(modifier = Modifier.fillMaxWidth())
    }
}