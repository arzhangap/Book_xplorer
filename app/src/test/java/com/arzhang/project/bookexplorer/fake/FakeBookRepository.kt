package com.arzhang.project.bookexplorer.fake

import com.arzhang.project.bookexplorer.data.BookxRepository
import com.arzhang.project.bookexplorer.model.Book
import com.arzhang.project.bookexplorer.model.BookSearchResult

class FakeBookRepository : BookxRepository {
    override suspend fun getSearchResult(): BookSearchResult {
        return FakeDataSource.searchResult
    }

    override suspend fun getBookInfo(bookId: String): Book {
        return FakeDataSource.bookInfo1
    }
}