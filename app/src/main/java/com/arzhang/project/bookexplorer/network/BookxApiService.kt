package com.arzhang.project.bookexplorer.network

import com.arzhang.project.bookexplorer.model.Book
import com.arzhang.project.bookexplorer.model.BookSearchResult
import retrofit2.http.GET
import retrofit2.http.Path

interface BookxApiService {
    @GET("volumes?q=Philosophy")
    suspend fun getSearchResult() : BookSearchResult

    @GET("volumes/{bookId}")
    suspend fun getBookInfo(@Path("bookId") bookId: String): Book
}