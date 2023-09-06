/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.arzhang.project.bookexplorer.fake

import com.arzhang.project.bookexplorer.model.Book
import com.arzhang.project.bookexplorer.model.BookSearchResult
import com.arzhang.project.bookexplorer.model.ImageLinks
import com.arzhang.project.bookexplorer.model.Item
import com.arzhang.project.bookexplorer.model.VolumeInfo

object FakeDataSource {

    private const val idOne = "book1"
    private const val idTwo = "book2"
    val bookInfo1 = Book(
        id = "book1",
        volumeInfo = VolumeInfo(
            title = "book1",
            imageLinks = ImageLinks(thumbnail = "link.one")
        )
    )
    val searchResult = BookSearchResult(
        arrayListOf<Item>(
            Item("idOne"),
            Item("IdTwo")
        )
    )
}
