package com.arzhang.project.bookexplorer.data

import com.arzhang.project.bookexplorer.network.BookxApiService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

interface AppContainer {
    val bookxRepository: BookxRepository
}

class DefaultAppContainer() : AppContainer {

    private val baseUrl="https://www.googleapis.com/books/v1/"
    private val json = Json { ignoreUnknownKeys = true }

    private val retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
        .build()

    private val retrofitService = retrofit.create(BookxApiService::class.java)

    override val bookxRepository: BookxRepository by lazy {
        NetworkBookxRepository(retrofitService)
    }
}