package com.droidcon.borrow.ui.composables

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.droidcon.borrow.data.models.BorrowItem
import com.droidcon.borrow.ui.theme.BorrowTheme

@Composable
fun BorrowedItemRow(item: BorrowItem) {

  /**
   * Since the card is a surface on top of the background,
   * set the card's background to the `surface` color from
   * the theme
   */
  Card(
    modifier = Modifier
      .fillMaxWidth()
      .padding(horizontal = 16.dp),
    shape = RoundedCornerShape(4.dp),
    backgroundColor = MaterialTheme.colors.surface,
    elevation = 4.dp
  ) {
    Column(
      modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp)
    ) {
      Text(
        text = item.itemName,
        fontSize = 18.sp,
        fontWeight = FontWeight.Bold
      )
      Spacer(modifier = Modifier.padding(top = 10.dp))
      Text(text = item.borrowerName)
      Spacer(modifier = Modifier.padding(top = 10.dp))
      Text(text = item.borrowDate)
    }
  }
}

/**
 * A regular preview using the default theme - which is a
 * light theme
 */
@Preview
@Composable
fun BorrowedItemRowPreview() {
  BorrowTheme {
    BorrowedItemRow(
      BorrowItem(
        id = 0,
        itemName = "PlayStation",
        borrowerName = "Steve",
        borrowDate = "2-11-2022"
      )
    )
  }
}

/**
 * Preview the Composable using the dark theme colors of the
 * BorrowTheme theme
 */
@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun BorrowedItemRowDarkPreview() {
  BorrowTheme {
    BorrowedItemRow(
      BorrowItem(
        id = 0,
        itemName = "PlayStation",
        borrowerName = "Steve",
        borrowDate = "2-11-2022"
      )
    )
  }
}