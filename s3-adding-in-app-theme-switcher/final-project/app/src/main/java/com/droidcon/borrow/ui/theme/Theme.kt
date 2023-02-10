package com.droidcon.borrow.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.staticCompositionLocalOf

// overridden colors for light theme
private val LightColors = lightColors(
  primary = md_theme_light_primary,
  onPrimary = md_theme_light_onPrimary,
  secondary = md_theme_light_secondary,
  onSecondary = md_theme_light_onSecondary,
  background = md_theme_light_background,
  onBackground = md_theme_light_onBackground,
  surface = md_theme_light_surface,
  onSurface = md_theme_light_onSurface,
)

// overridden colors for dark theme
private val DarkColors = darkColors(
  primary = md_theme_dark_primary,
  onPrimary = md_theme_dark_onPrimary,
  secondary = md_theme_dark_secondary,
  onSecondary = md_theme_dark_onSecondary,
  background = md_theme_dark_background,
  onBackground = md_theme_dark_onBackground,
  surface = md_theme_dark_surface,
  onSurface = md_theme_dark_onSurface,
)

enum class Theme {
  LIGHT,
  DARK,
  FOLLOW_SYSTEM
}

val LocalTheme = staticCompositionLocalOf<MutableState<Theme>> {
  error("Theme not provided")
}

/**
 * isSystemInDarkTheme() returns the current state of theme system.
 * Any changes in the return value of isSystemInDarkTheme causes recomposition of the entire hierarchy
 */
@Composable
fun BorrowTheme(initialTheme: Theme = Theme.FOLLOW_SYSTEM, content: @Composable () -> Unit) {

  // choose color scheme based on system theme
  val colors = when (initialTheme) {
    Theme.LIGHT -> LightColors
    Theme.DARK -> DarkColors
    Theme.FOLLOW_SYSTEM -> if (isSystemInDarkTheme()) {
      DarkColors
    } else {
      LightColors
    }
  }

  MaterialTheme(
    colors = colors,
    typography = Typography,
    shapes = Shapes,
    content = content
  )
}