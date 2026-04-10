package com.saferapps.sabiondo.app.theme

import androidx.compose.material3.*
import androidx.compose.runtime.Composable

private val DarkColors = darkColorScheme(
    primary = Primary,
    secondary = Secondary,
    background = Background,
    surface = Surface,
    onPrimary = OnPrimary
)

@Composable
fun SabiondoTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = DarkColors,
        typography = Typography,
        content = content
    )
}