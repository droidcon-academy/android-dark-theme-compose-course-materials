package com.droidcon.borrow

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.droidcon.borrow.navigation.AppNavigation
import com.droidcon.borrow.ui.theme.BorrowTheme
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import org.koin.android.ext.android.inject

@OptIn(ExperimentalAnimationApi::class)
class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      val navController = rememberAnimatedNavController()
      val borrowViewModel: BorrowViewModel by inject()

      BorrowTheme {
        AppNavigation(navController = navController, viewModel = borrowViewModel)
      }
    }
  }
}

@Composable
fun Greeting(name: String) {
  Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
  BorrowTheme {
    Greeting("Android")
  }
}