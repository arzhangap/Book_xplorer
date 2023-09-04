package com.arzhang.project.bookexplorer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.arzhang.project.bookexplorer.ui.BookxApp
import com.arzhang.project.bookexplorer.ui.theme.BookExplorerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BookExplorerTheme {
                BookxApp()
            }
        }
    }
}