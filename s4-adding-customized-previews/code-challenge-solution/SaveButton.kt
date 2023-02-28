package com.droidcon.borrow.ui.composables

import android.content.res.Configuration
import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.droidcon.borrow.BorrowViewModel
import com.droidcon.borrow.ui.theme.BorrowTheme

@Composable
fun SaveButton(viewModel: BorrowViewModel? = null, navController: NavController? = null) {
  val context = LocalContext.current

  Button(
    onClick = {
      if (viewModel?.validateInputs() == true) {
        viewModel.addItem()
        navController?.popBackStack()
      } else {
        Toast.makeText(context, "Please fill all the fields", Toast.LENGTH_SHORT).show()
      }

    },
    modifier = Modifier
      .fillMaxWidth()
      .padding(10.dp),
    shape = RoundedCornerShape(6.dp)
  ) {
    Text(
      text = "Save Item",
      modifier = Modifier
        .padding(6.dp),
    )
  }
}

@Preview
@Composable
fun SaveButtonPreview() {
  BorrowTheme {
    SaveButton()
  }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun SaveButtonPreviewDark() {
  BorrowTheme {
    SaveButton()
  }
}