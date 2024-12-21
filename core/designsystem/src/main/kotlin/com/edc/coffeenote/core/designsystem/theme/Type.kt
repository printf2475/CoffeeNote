package com.edc.coffeenote.core.designsystem.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.edc.coffeenote.core.designsystem.R

val pretendardFontFamily = FontFamily(
    Font(R.font.pretendard_medium, FontWeight.Medium),
    Font(R.font.pretendard_bold, FontWeight.Bold),
)

val boldStyle = TextStyle(
    fontFamily = pretendardFontFamily,
    fontWeight = FontWeight(700)
)

val mediumStyle = TextStyle(
    fontFamily = pretendardFontFamily,
    fontWeight = FontWeight(500)
)

internal val typography = CoffeeNoteTypography()

/**
 * CoffeeNote typography.
 */
@Immutable
data class CoffeeNoteTypography(
    // bold
    val b40: TextStyle = boldStyle.copy(fontSize = 40.sp),
    val b40L130: TextStyle = b40.copy(lineHeight = 52.sp),
    val b40L160: TextStyle = b40.copy(lineHeight = 64.sp),

    val b36: TextStyle = boldStyle.copy(fontSize = 36.sp),
    val b36L130: TextStyle = b36.copy(lineHeight = 48.sp),
    val b36L160: TextStyle = b36.copy(lineHeight = 58.sp),

    val b32: TextStyle = boldStyle.copy(fontSize = 32.sp),
    val b32L130: TextStyle = b32.copy(lineHeight = 42.sp),
    val b32L160: TextStyle = b32.copy(lineHeight = 50.sp),

    val b28: TextStyle = boldStyle.copy(fontSize = 28.sp),
    val b28L130: TextStyle = b28.copy(lineHeight = 36.sp),
    val b28L160: TextStyle = b28.copy(lineHeight = 44.sp),

    val b24: TextStyle = boldStyle.copy(fontSize = 24.sp),
    val b24L130: TextStyle = b24.copy(lineHeight = 32.sp),
    val b24L160: TextStyle = b24.copy(lineHeight = 38.sp),

    val b20: TextStyle = boldStyle.copy(fontSize = 20.sp),
    val b20L130: TextStyle = b20.copy(lineHeight = 26.sp),
    val b20L160: TextStyle = b20.copy(lineHeight = 32.sp),

    val b18: TextStyle = boldStyle.copy(fontSize = 18.sp),
    val b18L130: TextStyle = b18.copy(lineHeight = 24.sp),
    val b18L160: TextStyle = b18.copy(lineHeight = 30.sp),

    val b16: TextStyle = boldStyle.copy(fontSize = 16.sp),
    val b16L130: TextStyle = b16.copy(lineHeight = 20.sp),
    val b16L160: TextStyle = b16.copy(lineHeight = 26.sp),

    val b14: TextStyle = boldStyle.copy(fontSize = 14.sp),
    val b14L130: TextStyle = b14.copy(lineHeight = 18.sp),
    val b14L160: TextStyle = b14.copy(lineHeight = 22.sp),

    val b12: TextStyle = boldStyle.copy(fontSize = 12.sp),
    val b12L130: TextStyle = b12.copy(lineHeight = 16.sp),
    val b12L160: TextStyle = b12.copy(lineHeight = 20.sp),

    val b11: TextStyle = boldStyle.copy(fontSize = 11.sp),
    val b11L130: TextStyle = b11.copy(lineHeight = 14.sp),
    val b11L160: TextStyle = b11.copy(lineHeight = 18.sp),

    val b10: TextStyle = boldStyle.copy(fontSize = 10.sp),
    val b10L130: TextStyle = b10.copy(lineHeight = 12.sp),
    val b10L160: TextStyle = b10.copy(lineHeight = 16.sp),

    // medium
    val m40: TextStyle = mediumStyle.copy(fontSize = 40.sp),
    val m40L130: TextStyle = m40.copy(lineHeight = 52.sp),
    val m40L160: TextStyle = m40.copy(lineHeight = 64.sp),

    val m36: TextStyle = mediumStyle.copy(fontSize = 36.sp),
    val m36L130: TextStyle = m36.copy(lineHeight = 48.sp),
    val m36L160: TextStyle = m36.copy(lineHeight = 58.sp),

    val m32: TextStyle = mediumStyle.copy(fontSize = 32.sp),
    val m32L130: TextStyle = m32.copy(lineHeight = 42.sp),
    val m32L160: TextStyle = m32.copy(lineHeight = 50.sp),

    val m28: TextStyle = mediumStyle.copy(fontSize = 28.sp),
    val m28L130: TextStyle = m28.copy(lineHeight = 36.sp),
    val m28L160: TextStyle = m28.copy(lineHeight = 44.sp),

    val m24: TextStyle = mediumStyle.copy(fontSize = 24.sp),
    val m24L130: TextStyle = m24.copy(lineHeight = 32.sp),
    val m24L160: TextStyle = m24.copy(lineHeight = 38.sp),

    val m20: TextStyle = mediumStyle.copy(fontSize = 20.sp),
    val m20L130: TextStyle = m20.copy(lineHeight = 26.sp),
    val m20L160: TextStyle = m20.copy(lineHeight = 32.sp),

    val m18: TextStyle = mediumStyle.copy(fontSize = 18.sp),
    val m18L130: TextStyle = m18.copy(lineHeight = 24.sp),
    val m18L160: TextStyle = m18.copy(lineHeight = 30.sp),

    val m16: TextStyle = mediumStyle.copy(fontSize = 16.sp),
    val m16L130: TextStyle = m16.copy(lineHeight = 20.sp),
    val m16L160: TextStyle = m16.copy(lineHeight = 26.sp),

    val m15: TextStyle = mediumStyle.copy(fontSize = 15.sp),
    val m15L130: TextStyle = m15.copy(lineHeight = 20.sp),
    val m15L160: TextStyle = m15.copy(lineHeight = 24.sp),

    val m14: TextStyle = mediumStyle.copy(fontSize = 14.sp),
    val m14L130: TextStyle = m14.copy(lineHeight = 18.sp),
    val m14L160: TextStyle = m14.copy(lineHeight = 22.sp),

    val m12: TextStyle = mediumStyle.copy(fontSize = 12.sp),
    val m12L130: TextStyle = m12.copy(lineHeight = 16.sp),
    val m12L160: TextStyle = m12.copy(lineHeight = 20.sp),

    val m11: TextStyle = mediumStyle.copy(fontSize = 11.sp),
    val m11L130: TextStyle = m11.copy(lineHeight = 14.sp),
    val m11L160: TextStyle = m11.copy(lineHeight = 18.sp),

    val m10: TextStyle = mediumStyle.copy(fontSize = 10.sp),
    val m10L130: TextStyle = m10.copy(lineHeight = 12.sp),
    val m10L160: TextStyle = m10.copy(lineHeight = 16.sp),
)

val LocalTypography = staticCompositionLocalOf { typography }
