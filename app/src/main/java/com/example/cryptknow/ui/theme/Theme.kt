package com.example.cryptknow.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
    primary = DarkBlue,
    primaryVariant = NormalBlue,
    secondary = YellowSec,
    secondaryVariant = YellowSecLight,
    background = DarkBlue,
    surface = NormalBlue,
    error = Color.Red,
    onPrimary = Color.White,
    onBackground = Color.White,
    onSurface = Color.White,
    onError = Color.Red
)

private val LightColorPalette = lightColors(
    primary = NormalBlue,
    primaryVariant = LightBlue,
    secondary = YellowSec,
    secondaryVariant = YellowSecLight,
    background = NormalBlue,
    surface = LightBlue,
    error = Color.Red,
    onPrimary = Color.White,
    onBackground = Color.White,
    onSurface = Color.White,
    onError = Color.White
)

@Composable
fun CryptKnowTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}