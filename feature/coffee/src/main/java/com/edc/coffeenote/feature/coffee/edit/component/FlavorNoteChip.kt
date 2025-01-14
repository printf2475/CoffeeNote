package com.edc.coffeenote.feature.coffee.edit.component

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.edc.coffeenote.core.designsystem.theme.Brown300
import com.edc.coffeenote.core.designsystem.theme.CoffeeNoteTheme
import com.edc.coffeenote.core.designsystem.theme.LocalTypography
import com.edc.coffeenote.core.util.noRippleClick

@Composable
fun FlavorNoteChip(
    note: String,
    onClick: (String) -> Unit
) {
    val typography = LocalTypography.current
    Row(
        modifier = Modifier
            .border(1.dp, Brown300, RoundedCornerShape(12.dp))
            .padding(8.dp)
            .noRippleClick { onClick(note) },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(2.dp)
    ) {
        Text(
            text = note,
            style = typography.b14
        )

        Icon(
            modifier = Modifier.size(14.dp),
            imageVector = Icons.Default.Clear,
            contentDescription = null
        )
    }
}

@Preview
@Composable
private fun FlavorNoteChipPreview() {
    CoffeeNoteTheme {
        FlavorNoteChip("test", {})
    }
}