package com.edc.coffeenote.core.designsystem.theme

import androidx.compose.ui.graphics.Color

/**
 * Global Token
 * 글로벌 토큰은 디자인 언어의 기본 값으로, 이름이나 그 자체로 표현됩니다.
 * 컬러 그룹 - 숫자 로 표현되며, 100단위로 증감합니다. 단, White 및 Black은 별도로 표기합니다.
 *
 */
internal val White = Color.White
internal val White10 = Color(0x1AFFFFFF)
internal val White15 = Color(0x26FFFFFF)
internal val White20 = Color(0x33FFFFFF)
internal val White30 = Color(0x4DFFFFFF)
internal val White40 = Color(0x66FFFFFF)
internal val White50 = Color(0x80FFFFFF)
internal val White60 = Color(0x99FFFFFF)
internal val White70 = Color(0xB2FFFFFF)
internal val White80 = Color(0xCCFFFFFF)
val White90 = Color(0xE5FFFFFF)

internal val Black = Color.Black
internal val Black3 = Color(0x08000000)
internal val Black5 = Color(0x0D000000)
internal val Black10 = Color(0x1A000000)
internal val Black20 = Color(0x33000000)
internal val Black30 = Color(0x4D000000)
internal val Black40 = Color(0x66000000)
internal val Black50 = Color(0x80000000)
internal val Black60 = Color(0x99000000)
internal val Black70 = Color(0xB2000000)
val Black80 = Color(0xCC000000)
internal val Black90 = Color(0xE5000000)

internal val Primary100 = Color(0xFFF3F2FD)
internal val Primary200 = Color(0xFFDEDDF9)
internal val Primary300 = Color(0xFFB4B2F1)
internal val Primary400 = Color(0xFF7571E5)
internal val Primary500 = Color(0xFF4B46DD)
internal val Primary600 = Color(0xFF2B25CB)
internal val Primary700 = Color(0xFF221DA0)
internal val Primary800 = Color(0xFF14115F)
internal val Primary900 = Color(0xFF0B0934)

internal val Gray100 = Color(0xFFF4F5F7)
internal val Gray200 = Color(0xFFE5E7EB)
internal val Gray300 = Color(0xFFD3D6DB)
internal val Gray400 = Color(0xFFA0A6B1)
internal val Gray500 = Color(0xFF6C727F)
internal val Gray600 = Color(0xFF4D5562)
internal val Gray700 = Color(0xFF2D323B)
internal val Gray800 = Color(0xFF202227)
internal val Gray900 = Color(0xFF151515)

internal val Yellow100 = Color(0xFFFFF9E0)
internal val Yellow200 = Color(0xFFFFF5C6)
internal val Yellow300 = Color(0xFFFFE77A)
internal val Yellow400 = Color(0xFFFFDD47)
internal val Yellow500 = Color(0xFFFFD92D)
internal val Yellow600 = Color(0xFFFFD014)
internal val Yellow700 = Color(0xFFFFC414)
internal val Yellow800 = Color(0xFFFFB514)
internal val Yellow900 = Color(0xFFFAA507)

internal val Red100 = Color(0xFFFEF3F3)
internal val Red200 = Color(0xFFFDE4E4)
internal val Red300 = Color(0xFFFBB4B4)
internal val Red400 = Color(0xFFF88484)
internal val Red500 = Color(0xFFF55454)
internal val Red600 = Color(0xFFF22424)
internal val Red700 = Color(0xFFD60D0D)
internal val Red800 = Color(0xFFA60A0A)
internal val Red900 = Color(0xFF5E0505)

internal val Shadow = Color(0x1F000000)

/**
 * System Token
 * 글로벌 토큰과 비슷하지만, 여러 곳에서 사용될 때 사용합니다. “무엇을 하는가”로 지칭할 수 있습니다.
 * 토큰의 의도된 목적을 전달하는 데 도움이 되며, 단일 목적을 가진 값이 여러 위치에 나타날 때 효과적입니다.
 *
 */
interface Background {
    val primary: Color
    val secondary: Color
}

object LightBackground : Background {
    override val primary: Color = White
    override val secondary: Color = Gray100
}

object DarkBackground : Background {
    override val primary: Color = Gray900
    override val secondary: Color = Gray800
}

interface BackgroundExtension {
    val primary: Color
    val red: Color
    val yellow: Color
}

object LightBackgroundExtension : BackgroundExtension {
    override val primary: Color = Primary100
    override val red: Color = Red100
    override val yellow: Color = Yellow100
}

object DarkBackgroundExtension : BackgroundExtension {
    override val primary: Color = Primary800
    override val red: Color = Red900
    override val yellow: Color = Yellow900
}

interface Content {
    val primary: Color
    val secondary: Color
    val tertiary: Color
    val tertiary2: Color
    val tertiary3: Color
}

object LightContent : Content {
    override val primary: Color = Gray800
    override val secondary: Color = Gray700
    override val tertiary: Color = Gray500
    override val tertiary2: Color = Gray400
    override val tertiary3: Color = Gray300
}

object DarkContent : Content {
    override val primary: Color = Gray200
    override val secondary: Color = Gray300
    override val tertiary: Color = Gray400
    override val tertiary2: Color = Gray500
    override val tertiary3: Color = Gray600
}

interface ContentExtension {
    val primary: Color
    val red: Color
    val yellow: Color
}

object LightContentExtension : ContentExtension {
    override val primary: Color = Primary600
    override val red: Color = Red500
    override val yellow: Color = Yellow500
}

object DarkContentExtension : ContentExtension {
    override val primary: Color = Primary200
    override val red: Color = Red200
    override val yellow: Color = Yellow200
}

interface Border {
    val primary: Color
    val secondary: Color
}

object LightBorder : Border {
    override val primary: Color = Black10
    override val secondary: Color = Black5
}

object DarkBorder : Border {
    override val primary: Color = White15
    override val secondary: Color = White10
}

interface PrimaryButton {
    val background: Color
    val text: Color
    val pressedBackground: Color
    val disabledBackground: Color
    val disabledText: Color
}

object LightPrimaryButton : PrimaryButton {
    override val background: Color = Primary600
    override val text: Color = White
    override val pressedBackground: Color = Primary700
    override val disabledBackground: Color = Gray400
    override val disabledText: Color = White
}

object DarkPrimaryButton : PrimaryButton {
    override val background: Color = Primary500
    override val text: Color = White
    override val pressedBackground: Color = Primary400
    override val disabledBackground: Color = Gray600
    override val disabledText: Color = Gray400
}

interface SecondaryButton : PrimaryButton {
    override val background: Color
    override val text: Color
    override val pressedBackground: Color
    override val disabledBackground: Color
    override val disabledText: Color
}

object LightSecondaryButton : SecondaryButton {
    override val background: Color = Primary100
    override val text: Color = Primary600
    override val pressedBackground: Color = Primary200
    override val disabledBackground: Color = Gray400
    override val disabledText: Color = White
}

object DarkSecondaryButton : SecondaryButton {
    override val background: Color = Primary900
    override val text: Color = Primary100
    override val pressedBackground: Color = Primary800
    override val disabledBackground: Color = Gray600
    override val disabledText: Color = Gray400
}

interface TertiaryButton : PrimaryButton {
    override val background: Color
    override val text: Color
    override val pressedBackground: Color
    override val disabledBackground: Color
    override val disabledText: Color
}

object LightTertiaryButton : TertiaryButton {
    override val background: Color = Black3
    override val text: Color = Gray800
    override val pressedBackground: Color = Primary200
    override val disabledBackground: Color = Gray400
    override val disabledText: Color = White
}

object DarkTertiaryButton : TertiaryButton {
    override val background: Color = White15
    override val text: Color = Gray100
    override val pressedBackground: Color = White15
    override val disabledBackground: Color = Gray600
    override val disabledText: Color = Gray400
}

interface LineButton {
    val background: Color
    val text: Color
    val pressedBackground: Color
    val disabledText: Color
}

object LightLineButton : LineButton {
    override val background: Color = Black10
    override val text: Color = Gray800
    override val pressedBackground: Color = Black10
    override val disabledText: Color = Gray300
}

object DarkLineButton : LineButton {
    override val background: Color = White15
    override val text: Color = Gray100
    override val pressedBackground: Color = White15
    override val disabledText: Color = Gray600
}

interface DimOverlay {
    val primary: Color
    val secondary: Color
}

object LightDimOverlay : DimOverlay {
    override val primary: Color = Black80
    override val secondary: Color = Black50
}

object DarkDimOverlay : DimOverlay {
    override val primary: Color = White80
    override val secondary: Color = White50
}