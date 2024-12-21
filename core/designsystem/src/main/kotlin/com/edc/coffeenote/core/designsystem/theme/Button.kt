package com.edc.coffeenote.core.designsystem.theme

import androidx.compose.material3.ButtonColors
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

@Immutable
data class ButtonTheme(
    val primary: ButtonStyle = ButtonStyle(
        buttonColors = ButtonColors(
            contentColor = LightPrimaryButton.text,
            containerColor = LightPrimaryButton.background,
            disabledContainerColor = LightPrimaryButton.disabledBackground,
            disabledContentColor = LightPrimaryButton.disabledText
        )
    ),
    val secondary: ButtonStyle = ButtonStyle(
        buttonColors = ButtonColors(
            contentColor = LightSecondaryButton.text,
            containerColor = LightSecondaryButton.background,
            disabledContainerColor = LightSecondaryButton.disabledBackground,
            disabledContentColor = LightSecondaryButton.disabledText,
        )
    ),
    val tertiary: ButtonStyle = ButtonStyle(
        buttonColors = ButtonColors(
            contentColor = LightTertiaryButton.text,
            containerColor = LightTertiaryButton.background,
            disabledContainerColor = LightTertiaryButton.disabledBackground,
            disabledContentColor = LightTertiaryButton.disabledText,
        )
    ),

    val outline: ButtonStyle = ButtonStyle(
        buttonColors = ButtonColors(
            contentColor = LightLineButton.text,
            containerColor = Color.Transparent,
            disabledContainerColor = Color.Transparent,
            disabledContentColor = LightLineButton.disabledText,
        ),
        outlineColor = LightBorder.secondary
    ),

    val other: ButtonStyle = ButtonStyle()
)

@Immutable
data class ButtonStyle(
    val buttonColors: ButtonColors = ButtonColors(
        containerColor = Color.Unspecified,
        contentColor = Color.Unspecified,
        disabledContainerColor = Color.Unspecified,
        disabledContentColor = Color.Unspecified,
    ),
    val outlineColor: Color = Color.Unspecified
)


val darkButtonTheme = ButtonTheme(
    primary = ButtonStyle(
        buttonColors = ButtonColors(
            contentColor = DarkPrimaryButton.text,
            containerColor = DarkPrimaryButton.background,
            disabledContainerColor = DarkPrimaryButton.disabledBackground,
            disabledContentColor = DarkPrimaryButton.disabledText
        )
    ),
    secondary = ButtonStyle(
        buttonColors = ButtonColors(
            contentColor = DarkSecondaryButton.text,
            containerColor = DarkSecondaryButton.background,
            disabledContainerColor = DarkSecondaryButton.disabledBackground,
            disabledContentColor = DarkSecondaryButton.disabledText
        )
    ),
    tertiary = ButtonStyle(
        buttonColors = ButtonColors(
            contentColor = DarkTertiaryButton.text,
            containerColor = DarkTertiaryButton.background,
            disabledContainerColor = DarkTertiaryButton.disabledBackground,
            disabledContentColor = DarkTertiaryButton.disabledText
        )
    ),
    outline = ButtonStyle(
        buttonColors = ButtonColors(
            contentColor = DarkLineButton.text,
            containerColor = Color.Transparent,
            disabledContainerColor = Color.Transparent,
            disabledContentColor = DarkLineButton.text,
        ),
        outlineColor = DarkLineButton.text,
    )
)


val LocalButtonTheme = staticCompositionLocalOf { ButtonTheme() }