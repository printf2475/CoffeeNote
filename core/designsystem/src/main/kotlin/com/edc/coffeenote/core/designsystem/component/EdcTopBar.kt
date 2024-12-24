package com.edc.coffeenote.core.designsystem.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.edc.coffeenote.core.designsystem.theme.Brown300
import com.edc.coffeenote.core.designsystem.theme.CoffeeNoteTheme
import com.edc.coffeenote.core.designsystem.theme.LocalTypography

val TopBarHeight = 56.dp


@Composable
fun EdtTopBar(
    modifier: Modifier = Modifier,
    title: String,
    backgroundColor: Color = Brown300,
    onBackClick: (() -> Unit)? = null,
    actions: (@Composable RowScope.() -> Unit)? = null
) {
    val typography = LocalTypography.current
    Box(
        modifier = modifier
            .height(TopBarHeight)
            .background(backgroundColor)
    ) {
        if (onBackClick != null) {
            IconButton(
                modifier = Modifier.align(Alignment.CenterStart),
                onClick = onBackClick
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = null
                )
            }
        }

        Text(
            modifier = Modifier.align(Alignment.Center),
            text = title,
            style = typography.b20,
        )

        if (actions != null) {
            Row(
                modifier = Modifier.align(Alignment.CenterEnd),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                actions()
            }
        }
    }
}

@Preview
@Composable
private fun EdtTopBarPreview() {
    CoffeeNoteTheme {
        EdtTopBar(
            modifier = Modifier.fillMaxWidth(),
            title = "CoffeeNote",
            onBackClick = {},
            actions = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Default.Settings, contentDescription = null)
                }
            }
        )
    }
}