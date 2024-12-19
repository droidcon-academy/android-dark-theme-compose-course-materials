package com.droidcon.borrow.ui.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun EmptyStateScreen() {
  Column(
    modifier = Modifier
      .fillMaxHeight()
      .fillMaxWidth(),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Center
  ) {

    Icon(
      imageVector = Icons.Default.AccountBox,
      contentDescription = null,
      modifier = Modifier
        .size(60.dp, 60.dp),
      tint = Color(0xFF1C1B1F)
    )

    Spacer(
      modifier = Modifier
        .padding(top = 30.dp)
    )

    Text(
      text = "No items borrowed",
      modifier = Modifier
        .fillMaxWidth(),
      color = Color.Black,
      textAlign = TextAlign.Center,
      fontSize = 24.sp,
      fontWeight = FontWeight.Bold
    )
  }
}