package com.example.cryptknow.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
    primary = primary,
    primaryVariant = primaryDark,
    secondary = secondary,
    secondaryVariant = secondaryDark,
    background = primaryLight,
    surface = secondaryLight,
    error = Color.Red,
    onPrimary = secondary,
    onBackground = secondary,
    onSurface = primaryDark,
    onError = secondaryLight
)

private val LightColorPalette = lightColors(
    primary = primaryLight,
    primaryVariant = primary,
    secondary = secondaryLight,
    secondaryVariant = secondary,
    background = secondaryDark,
    surface = secondary,
    error = Color.Red,
    onPrimary = secondaryLight,
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