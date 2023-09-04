package com.arzhang.project.bookexplorer.model

import kotlinx.serialization.Serializable

@Serializable
data class BookSearchResult(
    val items: ArrayList<Item> = arrayListOf()
)

@Serializable
data class Item(
    val id: String
)

// ALL THE INFO ABOUT THE BOOK
@Serializable
data class Book(
    val id: String,
    val volumeInfo: VolumeInfo
)

@Serializable
data class VolumeInfo(
    val title: String,
//    val authors: List<Author>,
    val imageLinks: ImageLinks
)

@Serializable
data class ImageLinks(
    val thumbnail: String?
)

//@Serializable
//data class Author(
//    val author: String
//)