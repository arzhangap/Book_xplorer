package com.arzhang.project.bookexplorer.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.arzhang.project.bookexplorer.R
import com.arzhang.project.bookexplorer.model.Book

@Composable
fun HomeScreen(
    bookxUiState: BookxUiState,
    modifier: Modifier = Modifier
) {
    when(bookxUiState) {
        is BookxUiState.Success -> {
            BookCard(bookxUiState.bookLists)
        }
        is BookxUiState.Loading -> {
            Text("loading...")
        }
        is BookxUiState.Error -> {
            Text("failed...")
        }
    }
}

@Composable
fun BookCard(
    books: List<Book>,
) {
    LazyVerticalGrid(columns = GridCells.Adaptive(150.dp) ) {
        items(books) {book ->
            val thumbnail = book.volumeInfo.imageLinks.thumbnail?.replace("http","https")
            AsyncImage(
                model = ImageRequest.Builder(context = LocalContext.current)
                    .data(thumbnail)
                    .crossfade(true).build(),
                error = painterResource(R.drawable.ic_broken_image),
                placeholder = painterResource(R.drawable.loading_img),
                contentDescription = stringResource(R.string.book_detail),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
            )
        }
    }
}