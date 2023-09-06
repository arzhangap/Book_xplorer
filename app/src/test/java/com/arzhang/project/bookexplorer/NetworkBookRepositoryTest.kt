package com.arzhang.project.bookexplorer

import com.arzhang.project.bookexplorer.data.NetworkBookxRepository
import com.arzhang.project.bookexplorer.fake.FakeBookApiService
import com.arzhang.project.bookexplorer.fake.FakeDataSource
import org.junit.Assert.assertEquals
import kotlinx.coroutines.test.runTest
import org.junit.Test

class NetworkBookRepositoryTest {
    @Test
    fun networkBooksPhotosRepository_getBooksInfo_verifyBookInfo()=
        runTest {
            val repository = NetworkBookxRepository(
                bookxApiService = FakeBookApiService()
            )
            assertEquals(FakeDataSource.bookInfo1, repository.getBookInfo(""))
        }
    }