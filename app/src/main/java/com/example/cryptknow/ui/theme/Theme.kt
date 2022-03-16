package com.example.cryptknow.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
    primary = Grey500,
    primaryVariant = Grey200,
    secondary = YellowSec,
    secondaryVariant = YellowSecLight,
    background = Grey700,
    surface = Grey200,
    error = Color.Red,
    onPrimary = Color.White,
    onBackground = Color.White,
    onSurface = Color.White,
    onError = Color.White
)

private val LightColorPalette = lightColors(
    primary = LightGrey500,
    primaryVariant = LightGrey200,
    secondary = YellowSec,
    secondaryVariant = YellowSecLight,
    background = LightGrey200,
    surface = LightGrey200,
    error = Color.Red,
    onPrimary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
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