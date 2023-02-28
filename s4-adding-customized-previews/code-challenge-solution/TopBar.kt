package com.droidcon.borrow.ui.composables

import android.content.res.Configuration
import androidx.compose.foundation.clickable
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.droidcon.borrow.R
import com.droidcon.borrow.ui.theme.BorrowTheme

@Composable
fun TopBar(title: String) {
  TopAppBar(
    title = { Text(title) },
    actions = {
      var showPopup by remember { mutableStateOf(false) }

      Icon(
        painter = painterResource(id = R.drawable.ic_dark_mode),
        contentDescription = "Toggle theme",
        modifier = Modifier.clickable {
          showPopup = true
        }
      )

      val onPopupDismissed = { showPopup = false }
      if (showPopup) {
        ThemeDialog(onPopupDismissed)
      }
    }
  )
}

@Preview
@Composable
fun TopBarPreview() {
  BorrowTheme {
    TopBar("Borrow")
  }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun TopBarPreviewDark() {
  BorrowTheme {
    TopBar("Borrow")
  }
}