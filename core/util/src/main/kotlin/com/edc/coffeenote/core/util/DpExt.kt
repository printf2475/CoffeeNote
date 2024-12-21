package com.edc.coffeenote.core.util

import android.content.Context
import androidx.compose.ui.unit.Dp
import kotlin.math.roundToInt


/**
 * dp 값을 px 값으로 변환합니다.
 **/
fun Dp.toPx(context: Context): Int =
    (this.value * context.resources.displayMetrics.density).roundToInt()

/**
 * dp 값을 px 값으로 변환합니다.
 **/
fun Dp.toPxFloat(context: Context): Float = (this.value * context.resources.displayMetrics.density)

/**
 * px 값을 dp 값으로 변환합니다.
 **/
fun Int.toDp(context: Context): Dp = Dp(this / context.resources.displayMetrics.density)