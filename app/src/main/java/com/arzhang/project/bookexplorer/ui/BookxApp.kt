package com.arzhang.project.bookexplorer.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.arzhang.project.bookexplorer.ui.screens.BookxViewModel
import com.arzhang.project.bookexplorer.ui.screens.HomeScreen

@Composable
fun BookxApp() {
    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {
        val bookxViewModel: BookxViewModel =
            viewModel(factory = BookxViewModel.Factory)
        HomeScreen(
            bookxUiState = bookxViewModel.bookxUistate,
        )
    }
}

