package com.arzhang.project.bookexplorer.ui.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.arzhang.project.bookexplorer.BookxApplication
import com.arzhang.project.bookexplorer.data.BookxRepository
import com.arzhang.project.bookexplorer.model.Book
import com.arzhang.project.bookexplorer.model.BookSearchResult
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

sealed interface BookxUiState {
        data class Success(val bookLists: List<Book>) : BookxUiState
    object Error: BookxUiState
    object Loading: BookxUiState
}

class BookxViewModel(private val bookxRepository: BookxRepository) : ViewModel() {
    var bookxUistate: BookxUiState by mutableStateOf(BookxUiState.Loading)
        private set

    init {
        getBookList()
    }

    fun getBookList() {
        viewModelScope.launch {
            bookxUistate = try {
                val searchResult = bookxRepository.getSearchResult()
                BookxUiState.Success(bookLists = getBookList(searchResult))
            } catch (e: IOException) {
                BookxUiState.Loading
            } catch (e: HttpException) {
                BookxUiState.Loading
            }
        }
    }

    private suspend fun getBookList(searchResult: BookSearchResult): List<Book> {
        val booksList = mutableListOf<Book>()
        searchResult.items.forEach {item->
            val bookItem = bookxRepository.getBookInfo(item.id)
            booksList.add(bookItem)
        }
        return booksList
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as BookxApplication)
                val bookxRepo = application.container.bookxRepository
                BookxViewModel(bookxRepo)
            }
        }
    }

}